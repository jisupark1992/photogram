package com.cos.photogramstart.domain.subscribe;

import com.cos.photogramstart.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

// JPA - Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API 제공)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // 디비에 테이블을 생성
@Table(
		name="subscribe",
		uniqueConstraints={
				@UniqueConstraint(
						name = "subscribe_uk",
						columnNames={"fromUserId","toUserId"}
				)
		}
)
public class Subscribe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략이 데이터베이스를 따라간다.
	private int id;

	@JoinColumn(name = "fromUserId")
	@ManyToOne
	private User fromUser;

	@JoinColumn(name = "toUserId")
	@ManyToOne
	private User toUser;

	private LocalDateTime createDate;

	@PrePersist
	public void createDate(){
		this.createDate = LocalDateTime.now();
	}
}
