package badcode;

import java.util.Arrays;

public class RegisterBusiness {
	
    final String FIRST_NAME_CAPTION = "First name";
    final String LAST_NAME_CAPTION = "Last name";
    final String EMAIL_CAPTION = "Email";

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;
        String[] domains = {"gmail.com", "live.com"};

        checkRequireField(speaker.getFirstName(), FIRST_NAME_CAPTION);
		checkRequireField(speaker.getLastName(), LAST_NAME_CAPTION);
		checkRequireField(speaker.getEmail(), EMAIL_CAPTION);
        
        // Tasks
        String emailDomain = getEmailDomain(speaker.getEmail());
        if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 1) {
            int exp = speaker.getExp();
            speaker.setRegistrationFee(getFee(exp));
            try {
                speakerId = repository.saveSpeaker(speaker);
            }catch (Exception exception) {
                throw new SaveSpeakerException("Can't save a speaker.");
            }
        } else {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }

        return speakerId;
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
