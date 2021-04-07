package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/{id}")
public class CharacterInfoController {
//   /users/{id}/characters/{characterId}
	@RequestMapping("/characters/{characterId}")
	//id라는 템플릿변수에 저장된 값을 저장(이름다를경우)
	public String characterInfo(@PathVariable("id") String userId,
				//이름이 같을경우
				@PathVariable int characterId, ModelMap model) {
		model.addAttribute("userId", userId);
		model.addAttribute("characterId", characterId);
		return "game/users/info";
	}
}