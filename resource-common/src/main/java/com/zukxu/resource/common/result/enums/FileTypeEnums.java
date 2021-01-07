package com.zukxu.resource.common.result.enums;

/**
 * <p>
 * 文件类型枚举类
 * </p>
 *
 * @author zukxu
 * @date 2021/1/7 0007 10:46
 */
public enum FileTypeEnums {
	/*——————————————————图片格式——————————————————————*/
	/**
	 * JEPG.
	 */
	JPEG("FFD8FF"),

	/**
	 * PNG.
	 */
	PNG("89504E47"),

	/**
	 * GIF.
	 */
	GIF("47494638"),

	/**
	 * TIFF.
	 */
	TIFF("49492A00"),

	/**
	 * Windows Bitmap.
	 */
	BMP("424D"),

	/**
	 * CAD.
	 */
	DWG("41433130"),

	/**
	 * Adobe Photoshop.
	 */
	PSD("38425053"),
	/**
	 * 数码格式
	 */
	RAW("2E7261FD"),
	/**
	 * Rich Text Format.
	 */
	RTF("7B5C727466"),

	/**
	 * XML.
	 */
	XML("3C3F786D6C"),

	/**
	 * HTML.
	 */
	HTML("68746D6C3E"),
	/**
	 * CSS.
	 */
	CSS("48544D4C207B0D0A0942"),
	/**
	 * JS.
	 */
	JS("696B2E71623D696B2E71"),
	/**
	 * Email [thorough only].
	 */
	EML("44656C69766572792D646174653A"),

	/**
	 * Outlook Express.
	 */
	DBX("CFAD12FEC5FD746F"),

	/**
	 * Outlook (pst).
	 */
	PST("2142444E"),

	/**
	 * MS Word/Excel.
	 */
	XLS_DOC("D0CF11E0A1B11AE1"),
	XLSX_DOCX("504B03040A0000000000874EE24"),
	/**
	 * Visio
	 */
	VSD("d0cf11e0a1b11ae10000"),
	/**
	 * MS Access.
	 */
	MDB("5374616E64617264204A"),
	/**
	 * WPS文字wps,表格et,演示dps都是一样的
	 */
	WPS("D0CF11E0A1B11AE1"),
	/**
	 * torrent
	 */
	TORRENT("6431303A637265617465"),
	/**
	 * WordPerfect.
	 */
	WPD("FF575043"),

	/**
	 * Postscript.
	 */
	EPS("252150532D41646F6265"),

	/**
	 * Adobe Acrobat.
	 */
	PDF("255044462D312E"),

	/**
	 * Quicken.
	 */
	QDF("AC9EBD8F"),

	/**
	 * Windows Password.
	 */
	PWL("E3828596"),

	/**
	 * ZIP Archive.
	 */
	ZIP("504B030414"),

	/**
	 * RAR Archive.
	 */
	RAR("52617221"),
	/**
	 * GZ
	 */
	GZ("1F8B08004686F65F"),
	/**
	 * TAR
	 */
	TAR("E69687E5AD97E69687E7A8BF312E646F6378"),
	/**
	 * JSP Archive.
	 */
	JSP("3C2540207061676520"),
	/**
	 * JAVA Archive.
	 */
	JAVA("7061636B61676520"),
	/**
	 * CLASS Archive.
	 */
	CLASS("CAFEBABE0000002E00"),
	/**
	 * JAR Archive.
	 */
	JAR("504B03040A000000"),
	/**
	 * MF Archive.
	 */
	MF("4D616E69666573742D56"),
	/**
	 * EXE Archive.
	 */
	EXE("4D5A9000030000000400"),
	/**
	 * CHM Archive.
	 */
	CHM("49545346030000006000"),
	/**
	 * INI
	 */
	INI("235468697320636F6E66"),
	/**
	 * SLQ
	 */
	SQL("494E5345525420494E54"),
	/**
	 * BAT
	 */
	BAT("406563686F206f66660D"),

	/**
	 * PROPERTIES
	 */
	PROPERTIES("6C6F67346A2E726F6F74"),
	/**
	 * MXP
	 */
	MXP("04000000010000001300"),
	/**
	 * Wave.
	 */
	WAV("57415645"),

	/**
	 * AVI.
	 */
	AVI("41564920"),

	/**
	 * Real Audio.
	 */
	RAM("2E7261FD"),

	/**
	 * Real Media.
	 */
	RM("2E524D46"),
	/**
	 * MPEG (mpg).
	 */
	MPG("000001BA"),

	/**
	 * Quicktime.
	 */
	MOV("6D6F6F76"),
	

	/**
	 * Windows Media.
	 */
	ASF("3026B2758E66CF11"),

	/**
	 * MIDI.
	 */
	MID("4D546864"),
	/**
	 * MP4.
	 */
	MP4("00000020667479706d70"),
	/**
	 * MP3.
	 */
	MP3("49443303"),
	/**
	 * APE 无损
	 */
	APE("FFFB9064"),
	/**
	 * FLAC
	 */
	FLAC("664C6143"),
	/**
	 * FLV.
	 */
	FLV("464C5601050000000900");


	private String value;

	/**
	 * Constructor.
	 *
	 * @param value
	 */
	private FileTypeEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
