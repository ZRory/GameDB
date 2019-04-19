package vip.rory.gamedb.model;

import javax.persistence.Table;

/**
 * 
 * @fileName: Game.java
 * @describe:
 * @author: Rory
 * @date: 2018年7月16日
 * @version: 1.0.0
 */
@Table(name = "game")
public class Game extends BaseEntity {

	private String pageId;
	private String nameZh;
	private String nameEn;
	private String size;
	private String cover;
	private String thunderLink;
	private String torrentLink;

	/**
	 * @return the pageId
	 */
	public String getPageId() {
		return pageId;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	/**
	 * @return the nameZh
	 */
	public String getNameZh() {
		return nameZh;
	}

	/**
	 * @param nameZh the nameZh to set
	 */
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	/**
	 * @return the nameEn
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @param nameEn the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}

	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}

	/**
	 * @return the thunderLink
	 */
	public String getThunderLink() {
		return thunderLink;
	}

	/**
	 * @param thunderLink the thunderLink to set
	 */
	public void setThunderLink(String thunderLink) {
		this.thunderLink = thunderLink;
	}

	/**
	 * @return the torrentLink
	 */
	public String getTorrentLink() {
		return torrentLink;
	}

	/**
	 * @param torrentLink the torrentLink to set
	 */
	public void setTorrentLink(String torrentLink) {
		this.torrentLink = torrentLink;
	}

}
