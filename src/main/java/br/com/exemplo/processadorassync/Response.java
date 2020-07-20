package br.com.exemplo.processadorassync;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Response {
	private String id;
	private long origin;
	private String message;
}
