package br.com.exemplo.processadorassync;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Request {
	private String id;
	private long origin;
	private int messageIndex;

}
