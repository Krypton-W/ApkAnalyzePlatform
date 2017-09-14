package com.analysis.hibernate;

/**
 * Apk entity. @author MyEclipse Persistence Tools
 */

public class Apk implements java.io.Serializable {

	// Fields

	private Integer apkId;
	private String fileDirectoryName;
	private String apkName;
	private String apkType;
	private Integer developerId;
	private String versionName;
	private Boolean internet;
	private Boolean accessCoarseLocation;
	private Boolean accessFineLocation;
	private Boolean camera;
	private Boolean recordAudio;
	private Boolean readContacts;
	private Boolean writeContacts;
	private Boolean bluetooth;
	private Boolean nfc;
	private Boolean callaPhone;
	private Boolean readSms;
	private Boolean writeSms;
	private String iconDirectory;

	// Constructors

	/** default constructor */
	public Apk() {
		internet=false;
		accessCoarseLocation=false;
		accessFineLocation=false;
		camera=false;
		recordAudio=false;
		readContacts=false;
		writeContacts=false;
		bluetooth=false;
		nfc=false;
		callaPhone=false;
		readSms=false;
		writeSms=false;
	}

	/** minimal constructor */
	public Apk(String fileDirectoryName, String apkType) {
		this.fileDirectoryName = fileDirectoryName;
		this.apkType = apkType;
	}

	/** full constructor */
	public Apk(String fileDirectoryName, String apkName, String apkType, Integer developerId, String versionName,
			Boolean internet, Boolean accessCoarseLocation, Boolean accessFineLocation, Boolean camera,
			Boolean recordAudio, Boolean readContacts, Boolean writeContacts, Boolean bluetooth, Boolean nfc,
			Boolean callaPhone, Boolean readSms, Boolean writeSms, String iconDirectory) {
		this.fileDirectoryName = fileDirectoryName;
		this.apkName = apkName;
		this.apkType = apkType;
		this.developerId = developerId;
		this.versionName = versionName;
		this.internet = internet;
		this.accessCoarseLocation = accessCoarseLocation;
		this.accessFineLocation = accessFineLocation;
		this.camera = camera;
		this.recordAudio = recordAudio;
		this.readContacts = readContacts;
		this.writeContacts = writeContacts;
		this.bluetooth = bluetooth;
		this.nfc = nfc;
		this.callaPhone = callaPhone;
		this.readSms = readSms;
		this.writeSms = writeSms;
		this.iconDirectory = iconDirectory;
	}

	// Property accessors

	public Integer getApkId() {
		return this.apkId;
	}

	public void setApkId(Integer apkId) {
		this.apkId = apkId;
	}

	public String getFileDirectoryName() {
		return this.fileDirectoryName;
	}

	public void setFileDirectoryName(String fileDirectoryName) {
		this.fileDirectoryName = fileDirectoryName;
	}

	public String getApkName() {
		return this.apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}

	public String getApkType() {
		return this.apkType;
	}

	public void setApkType(String apkType) {
		this.apkType = apkType;
	}

	public Integer getDeveloperId() {
		return this.developerId;
	}

	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}

	public String getVersionName() {
		return this.versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public Boolean getInternet() {
		return this.internet;
	}

	public void setInternet(Boolean internet) {
		this.internet = internet;
	}

	public Boolean getAccessCoarseLocation() {
		return this.accessCoarseLocation;
	}

	public void setAccessCoarseLocation(Boolean accessCoarseLocation) {
		this.accessCoarseLocation = accessCoarseLocation;
	}

	public Boolean getAccessFineLocation() {
		return this.accessFineLocation;
	}

	public void setAccessFineLocation(Boolean accessFineLocation) {
		this.accessFineLocation = accessFineLocation;
	}

	public Boolean getCamera() {
		return this.camera;
	}

	public void setCamera(Boolean camera) {
		this.camera = camera;
	}

	public Boolean getRecordAudio() {
		return this.recordAudio;
	}

	public void setRecordAudio(Boolean recordAudio) {
		this.recordAudio = recordAudio;
	}

	public Boolean getReadContacts() {
		return this.readContacts;
	}

	public void setReadContacts(Boolean readContacts) {
		this.readContacts = readContacts;
	}

	public Boolean getWriteContacts() {
		return this.writeContacts;
	}

	public void setWriteContacts(Boolean writeContacts) {
		this.writeContacts = writeContacts;
	}

	public Boolean getBluetooth() {
		return this.bluetooth;
	}

	public void setBluetooth(Boolean bluetooth) {
		this.bluetooth = bluetooth;
	}

	public Boolean getNfc() {
		return this.nfc;
	}

	public void setNfc(Boolean nfc) {
		this.nfc = nfc;
	}

	public Boolean getCallaPhone() {
		return this.callaPhone;
	}

	public void setCallaPhone(Boolean callaPhone) {
		this.callaPhone = callaPhone;
	}

	public Boolean getReadSms() {
		return this.readSms;
	}

	public void setReadSms(Boolean readSms) {
		this.readSms = readSms;
	}

	public Boolean getWriteSms() {
		return this.writeSms;
	}

	public void setWriteSms(Boolean writeSms) {
		this.writeSms = writeSms;
	}

	public String getIconDirectory() {
		return this.iconDirectory;
	}

	public void setIconDirectory(String iconDirectory) {
		this.iconDirectory = iconDirectory;
	}

	public String toString()
	{
		return "this is toString";
	}
}