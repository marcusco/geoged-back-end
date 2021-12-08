package br.com.geoged.enums;

public enum ExceptionCodeEnum implements ErrorCodeEnum {

	GENERIC_APP_ERROR(1),
	GENERIC_METHOD_ERROR(2),
	JSON_CONVERSION_ERROR(3),
	OBJECT_CONVERSION_ERROR(4),
	MANDATORY_PARAM_MISSING(5),
	TREATED_RESULT_EXCEPTION(6),
	TREATED_CONSTRAINT_EXCEPTION(7),
	SESSION_SEND_MESSAGE_EXCEPTION(8),
	AUX_TURNO_RESULT_EXCEPTION(9);

	private final int code;

	private ExceptionCodeEnum(int code) {
		this.code = code;
	}

	@Override
	public int getCode() {
		return code;
	}

}
