package login.controller;

import login.data.DataFacadeImpl;
import login.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Random;

@Controller

public class FrontController {

    //use case controller (GRASP Controller) - injects concrete facade instance into controller
    private LoginController loginController = new LoginController(new DataFacadeImpl());
    private WishListController wishListController = new WishListController(new DataFacadeImpl());
    private ItemController itemController = new ItemController(new DataFacadeImpl());


    @GetMapping("/")
    public String getHome() {
        return "index";
    }

  /*  @GetMapping("/secretstuff")
    public String getSecretStuff(WebRequest request) {
        // Retrieve user object from web request (session scope)
        User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);

        // If user object is found on session, i.e. user is logged in, she/he can see secretstuff page
        if (user != null) {
            return "userpages/secretstuff";
        } else
            return "redirect:/";
    }

   */

    @PostMapping("/home")
    public String loginUser(WebRequest request) throws LoginSampleException {
        //Retrieve values from HTML form via WebRequest
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");

        // delegate work + data to login controller
        User user = loginController.login(email, pwd);
        Wishlist list = wishListController.getWishlist(user);
        setSessionInfo(request, user, list);

        // Go to to page dependent on role
        return "userpages/" + user.getRole();
    }


    @PostMapping("/register")
    public String createUser(WebRequest request) throws LoginSampleException {
        //Retrieve values from HTML form via WebRequest
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        // If passwords match, work + data is delegated to logic controller
        if (password1.equals(password2)) {
            User user = loginController.createUser(email, password1);
            Wishlist list = wishListController.getWishlist(user);
            setSessionInfo(request, user, list);

            // Go to page dependent on role
            return "userpages/" + user.getRole();

        } else { // If passwords don't match, an exception is thrown
            throw new LoginSampleException("The two passwords did not match");
        }
    }

    private void setSessionInfo(WebRequest request, User user, Wishlist list) {
        // Place user info on session
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("role", user.getRole(), WebRequest.SCOPE_SESSION);
        request.setAttribute("items", list.getItemlist(), WebRequest.SCOPE_SESSION);
    }


    @ExceptionHandler(Exception.class)
    public String anotherError(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());
        return "exceptionPage";
    }


    @PostMapping("AddToWishList")
    public String AddToWishList(WebRequest request) throws LoginSampleException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Item item = itemController.getItem(name);
        if (item == null) {
            item = itemController.createItem(new Item(name, description, new Random().nextDouble()*10000));

        }
        User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        Wishlist list = wishListController.addToWishList(user, item);

        setSessionInfo(request, user, list);
        return "userpages/customer";

    }


}