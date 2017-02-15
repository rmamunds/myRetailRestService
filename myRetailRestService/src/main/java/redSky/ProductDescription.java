package redSky;

/**
 * Product Description from redsky. Title in the case will be used for
 * myRetail's product name.
 * 
 * @author Robert Amundson
 *
 */
public class ProductDescription {

	private String title;
	private String[] bullet_description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getBullet_description() {
		return bullet_description;
	}

	public void setBullet_description(String[] bullet_description) {
		this.bullet_description = bullet_description;
	}

}
