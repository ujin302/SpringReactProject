package member.bean;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String name;
	private String id;
	private String pwd;
}
