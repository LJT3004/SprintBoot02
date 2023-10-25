package cn.bdqn.controller;

import cn.bdqn.pojo.Clubs;
import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.Players;
import cn.bdqn.service.ClubsService;
import cn.bdqn.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/players")
public class PlayersController {
    @Autowired
    private PlayersService playersService;
    @Autowired
    private ClubsService clubsService;
    @RequestMapping(value = "/selectAll")
    public String find(HttpSession session, @RequestParam(value = "pname",required = false)String pname, @RequestParam(value = "cid",required = false)Integer cid, @RequestParam(value = "currPageNo",defaultValue = "1")Integer currPageNo, Model model){
        if (pname!=null){
            session.setAttribute("pname",pname);
        }else {
            pname=(String)session.getAttribute("pname");
        }if (cid!=null){
            session.setAttribute("cid",cid);
        }else {
            cid=(Integer)session.getAttribute("cid");
        }
        PageBean<Players> pageBean=playersService.playersList(pname,cid,currPageNo,2);
        List<Clubs> clubsList=clubsService.clubsList();
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("clubsList",clubsList);
        return "list";
    }
    @RequestMapping(value = "/toadd")
    public String toadd(Model model){
        List<Clubs> clubsList=clubsService.clubsList();
        model.addAttribute("clubsList",clubsList);
        return "add";
    }
    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(Players players){
        int i=playersService.add(players);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "pid")int pid){
        int i=playersService.delete(pid);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }
}
