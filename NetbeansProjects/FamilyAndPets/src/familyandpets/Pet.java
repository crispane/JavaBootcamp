package familyandpets;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Pet {
	private String nickname;
	private String type;

	public Pet() {
	}

	public Pet(String nickname, String type) {
		this.nickname = nickname;
		this.type = type;
	}

	public String getNickname() {
		return nickname;
	}

	public String getType() {
		return type;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setType(String type) {
		this.type = type;
	}


}
