package juliany;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  private ArrayList<String> questions = new ArrayList<String>();

  private ArrayList<String> answers = new ArrayList<String>();

  private int countBadAnsw = 0;

  private Integer currentQue = 0;

  private int countQue;

  public MainController() {
    questions.add("ques 1");
    answers.add("answ 1");

    countQue = questions.size();
  }

  @RequestMapping("/")
  public String homePage() {
    return "home";
  }

  @RequestMapping("/testQuestion")
  public ModelAndView testQuestion(@RequestParam(name = "answer", required = false) String answer) {
    if (answer != null) {
      if ( !answers.get(currentQue).equalsIgnoreCase(answer)) {
        countBadAnsw++ ;
      } else {
        currentQue++ ;
      }
    }
    ModelAndView result = new ModelAndView("question");
    result.addObject("countBadAnsw", countBadAnsw);
    result.addObject("currentQue", currentQue);
    result.addObject("question", questions.get(currentQue));

    return result;
  }

  @RequestMapping("/finish")
  public String finishPage() {
    if (countQue <= currentQue) {
      return "/finish";
    }
    return "redirect:/testQuestion";
  }
}
