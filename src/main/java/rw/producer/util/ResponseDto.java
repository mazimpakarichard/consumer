package rw.producer.util;

public class ResponseDto {

	private Boolean status;
	private Object response;
	private String message;

	public ResponseDto(Exception exception) {
		this.status = false;
		this.response = exception.getMessage();
		this.message = exception.getMessage();
	}

	public ResponseDto() {
		this.message = "Action completed successfully";
		this.status = true;
	}

	public ResponseDto(Object response) {
		this.response = response;
		this.status = true;
		this.message = "Action completed successfully";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
