package controller;

public class CustomResponse {
    private String errorMessage;
    private String timeStamp;
    private String description;

    public CustomResponse(String errorMessage, String timeStamp, String description) {
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
        this.description = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
