package badcode;

import java.util.Arrays;

public class RegisterBusiness {
    final String[] VALID_DOMAIN = {"gmail.com", "live.com"};

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;

        validateRegisterData(speaker);
		
        int speakerExp = speaker.getExp();
        int registrationFee = getFee(speakerExp);
		speaker.setRegistrationFee(registrationFee);
        
        try {
            speakerId = repository.saveSpeaker(speaker);
        }catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

	private void validateRegisterData(Speaker speaker) {
		String speakerFirstName = speaker.getFirstName();
        String speakerLastName = speaker.getLastName();
        String speakerEmail = speaker.getEmail();
        
        checkRequireField(speakerFirstName, Speaker.FIRST_NAME_CAPTION);
		checkRequireField(speakerLastName, Speaker.LAST_NAME_CAPTION);
		checkRequireField(speakerEmail, Speaker.EMAIL_CAPTION);

		checkValidEmail(speakerEmail);
	}

	private void checkValidEmail(String email) {
		String emailDomain = getEmailDomain(email);
        final boolean isValidDomain = Arrays.stream(VALID_DOMAIN).filter(it -> it.equals(emailDomain)).count() == 1;
		if (!isValidDomain) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
	}

    int getFee(int exp) {
        int fee = 0;
        if (exp <= 1) {
            fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp <= 5) {
            fee = 100;
        } else if (exp <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if(inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }
    
    private void checkRequireField(String fieldValue, String fieldCaption) {
    	if (!hasValue(fieldValue)) {
    		throw new ArgumentNullException(fieldCaption + " is required.");
    	}
    }
    
    private boolean hasValue(String value) {
    	boolean hasValue = value != null && !value.isEmpty();
    	return hasValue;
    }

}
