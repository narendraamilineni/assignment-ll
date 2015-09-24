package naren.jersy.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@XmlRootElement
@Scope("prototype")
public class Status {

	@XmlElement(name="userId")
	protected Integer userId;
	@XmlElement(name="status")
    protected String status;
	@XmlElement(name="code")
    protected int code;
	@XmlElement(name="message")
	protected String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
