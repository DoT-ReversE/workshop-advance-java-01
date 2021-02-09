package badcode;

import java.util.Arrays;

public class RegisterBusiness {
	
    final String FIRST_NAME_CAPTION = "First name";
    final String LAST_NAME_CAPTION = "Last name";
    final String EMAIL_CAPTION = "Email";
    final String[] VALID_DOMAIN = {"gmail.com", "live.com"};

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;
       

        checkRequireField(speaker.getFirstName(), FIRST_NAME_CAPTION);
		checkRequireField(speaker.getLastName(), LAST_NAME_CAPTION);
		checkRequireField(speaker.getEmail(), EMAIL_CAPTION);
        
        checkValidEmail(speaker.getEmail());
		
        int exp = speaker.getExp();
        speaker.setRegistrationFee(getFee(exp));
        try {
            speakerId = repository.saveSpeaker(speaker);
        }catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
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
