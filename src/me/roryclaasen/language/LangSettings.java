package me.roryclaasen.language;

public class LangSettings {
	private boolean hardCodeFirst = true;
	private boolean keepValuesAfterLoad = false;
	private boolean debug = false;

	public boolean doHardCodeFirst() {
		return hardCodeFirst;
	}

	public void setHardCodeFirst(boolean hardCodeFirst) {
		this.hardCodeFirst = hardCodeFirst;
	}

	public boolean keepValuesAfterLoad() {
		return keepValuesAfterLoad;
	}

	public void setKeepValuesAfterLoad(boolean keepValuesAfterLoad) {
		this.keepValuesAfterLoad = keepValuesAfterLoad;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

}
