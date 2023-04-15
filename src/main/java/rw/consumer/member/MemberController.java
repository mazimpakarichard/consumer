/**
 * 
 */
package rw.consumer.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.google.gson.Gson;

import rw.producer.util.ResponseDto;
import rw.producer.util.XmlUtils;

/**
 * @author richard.mazimpaka
 *
 */
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private RestTemplate restTemplate;

//	private static final Gson gson = new Gson();

	private static final Gson gson = new Gson();

	@GetMapping("/national-id/{nationalId}")
	public MemberDto getMemberFromProducer(@PathVariable String nationalId) {
		MemberDto responseDto = null;
		String url = "http://localhost:8600/producer/national-identification";
		HttpHeaders headers = new HttpHeaders();
		headers.add("nationalId", nationalId);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				String.class);
		// ResponseEntity<MemberDto> response = restTemplate.getForEntity(url,
		// MemberDto.class);
		if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			responseDto = gson.fromJson(responseEntity.getBody(), MemberDto.class);
		}
		return responseDto;

	}

	@PostMapping("/create")
	public ResponseDto createMember(@RequestBody String member) {
		try {
			MemberDto responseDto = null;
			String url = "http://localhost:8600/producer/members";

			// Set headers
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);

			// Set request entity
			HttpEntity<String> requestEntity = new HttpEntity<String>(member, headers);
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

			if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
				responseDto = XmlUtils.fromXml(responseEntity.getBody(), MemberDto.class);
			}
			return new ResponseDto(responseDto);
		} catch (Exception e) {
			return new ResponseDto(e);
		}

	}

}
