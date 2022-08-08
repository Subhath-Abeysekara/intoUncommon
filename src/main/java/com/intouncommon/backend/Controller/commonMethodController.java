package com.intouncommon.backend.Controller;

import com.intouncommon.backend.Entity.*;
import com.intouncommon.backend.Service.adminService;
import com.intouncommon.backend.Service.commonMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin
public class commonMethodController {

    @Autowired
    private commonMethodService commonMethodService;

    @Autowired
    private adminService adminService;

    /**Security **/

    @PostMapping("/getKey")
    private String getKey(@RequestBody admin admin ,@RequestParam String ip){
        if(adminService.getLoginStatus(ip)){

            return adminService.madeSecreteKey(admin.getUsername(),admin.getPassword());
        }

        return "Error username or password";

    }
    @PostMapping("/checkAdmin")
    private String checkAdmin(@RequestBody admin admin){
        return adminService.madeSecreteKey(admin.getUsername(),admin.getPassword());
    }

    @PostMapping("/addAdmin")
    private String addAdmin(@RequestBody admin admin,@RequestHeader String header)throws Exception{

        if(adminService.checkTokenValidity(header)){
            adminService.addAdmin(admin);
            return "added successfully";
        }
        return "Wrong token";


    }
    @PutMapping ("/changeAdmin")
    private String changeAdmin(@RequestBody oldadmin admin,@RequestHeader String header)throws Exception{

        if(adminService.checkTokenValidity(header)){
            return adminService.changeAdmin(admin.getOldUsername(),admin.getUsername(),admin.getOldPassword(),admin.getPassword());
        }
        return "Wrong token";

    }

    @GetMapping("/getLogin/status")
    private String getLogin(@RequestParam String ip){
        
        if(adminService.getLoginStatus(ip)){
        
            return "true";
        }
            
        return "false";
    }

    @PostMapping("/addLogin")
    private int addLogin(logins login){
        return adminService.addLogin(login);
    }

    @GetMapping("/getLogin")
    private List<logins> getLoginFull(){
        return adminService.getLogin();
    }

    @PutMapping("/setLogin/status")
    private String setLogin(@RequestParam String ip){
        return adminService.setLoginStatus(ip);
    }

    @GetMapping("/test")
    private String test(@RequestParam String name,@RequestParam String age){

//        response response = new response();
//        response.setResponse("test pass");
//        return response;
        return name+age;
    }
    
    @GetMapping("/getvalidity")
    private String validityCheck(@RequestHeader String header) throws Exception {

//        response response = new response();
//        response.setResponse("test pass");
//        return response;
        if(adminService.checkTokenValidity(header)){
            return "successful";
        }
        return "Wrong token";
    }
    /** productions **/

    @GetMapping("/getproducts")
    private List<productResDto> getAllProducts(){
        return commonMethodService.getProductions();
    }

    @PostMapping(value="/product/add" ,consumes = "application/json", produces = "application/json")
    private Long addProduct(@RequestBody productionDto production,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.addProduction(production);
        }
        return null;

       // return "Successfully Added";
    }

    @PutMapping("/product/update")
    private String updateProduct(@RequestParam Long id, @RequestBody productions production,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.updateProduction(id,production);

        }
        return "Wrong token";


    }

    @DeleteMapping("/product/delete")
    private String deleteProduct(@RequestParam Long id,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.deleteProduction(id);
        }
        return "Wrong token";

    }

    @PostMapping("/product/url/add")
    private String addUrl(@RequestBody productImageDTO productImageDTO,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            commonMethodService.addImageUrl(productImageDTO);
            return "added";
        }
        return "Wrong token";


    }
    /** Category **/

    @GetMapping("/getcategories")
    private List<categories> getAllCategories(){
        return commonMethodService.getAllCategories();
    }

    @PostMapping("/category/add")
    private String addCategory(@RequestBody categories category,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            commonMethodService.addCategory(category);
            return "Successfully Added";
        }
        return "Wrong token";


    }

    @PutMapping("/category/update")
    private String updateCategory(@RequestParam Long id, @RequestBody categories category,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.updateCategory(id,category);
        }
        return "Wrong token";


    }

    @DeleteMapping("/category/delete")
    private String deleteCategory(@RequestParam Long id,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.deleteCategory(id);
        }
        return "Wrong token";


    }

    /** Producer **/

    @GetMapping("/getproducers")
    private List<producers> getAllProducers(@RequestHeader String header) throws Exception{
        if(adminService.checkTokenValidity(header)){

            return commonMethodService.getAllProducers();
        }
        return null;

        


    }

    @PostMapping("/producer/add")
    private String addProducer(@RequestBody producers producer,@RequestHeader String header) throws Exception{
        List<producers> producers = new ArrayList<>();
        System.out.println(header);
        System.out.println(adminService.checkTokenValidity(header));
        if(adminService.checkTokenValidity(header)){
            commonMethodService.addProducer(producer);
            return "Successfully Added";
        }
        return "Wrong token";


    }

    @PutMapping("/producer/update")
    private String updateProducer(@RequestParam Long id, @RequestBody producers producer,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.updateProducer(id,producer);
        }
        return "Wrong token";


    }

    @DeleteMapping("/producer/delete")
    private String deleteProducer(@RequestParam Long id,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.deleteProducer(id);
        }
        return "Wrong token";


    }

    /** StateCodes **/
    @GetMapping("/getstates")
    private List<statecodes> getAllStates(@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.getAllStates();
        }
        return null;


    }
    @PostMapping("/states/add")
    private String addStates(@RequestBody statecodes statecode,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            commonMethodService.addStateCode(statecode);
            return "Successfully Added";
        }
        return "Wrong token";


    }

    @PutMapping("/states/update")
    private String updateStates(@RequestParam Long id, @RequestBody statecodes statecode,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.updateStateCode(id,statecode);
        }
        return "Wrong token";


    }

    @DeleteMapping("/states/delete")
    private String deleteStates(@RequestParam Long id,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.deleteStateCode(id);
        }
        return "Wrong token";


    }

    /** Uncommon **/

    @PostMapping("/uncommon/add")
    private Long addUncommon(@RequestBody uncommonProductDto uncommonProduct,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.addUncommonProduction(uncommonProduct);
        }
        return null;


        //return "Successfully Added";
    }

    @PutMapping("/uncommon/update")
    private String updateUncommon(@RequestParam Long id, @RequestBody uncommonProduct uncommonProduct,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.updateUncommonProduction(id,uncommonProduct);
        }
        return "Wrong token";


    }

    @DeleteMapping("/uncommon/delete")
    private String deleteUncommon(@RequestParam Long id,@RequestHeader String header) throws Exception{

        if(adminService.checkTokenValidity(header)){
            return commonMethodService.deleteUncommonProduction(id);
        }
        return "Wrong token";


    }

    /** User **/
    @GetMapping("/getusers")
    private List<users> getAllUsers(){
        return commonMethodService.getAllUsers();
    }

    @PostMapping("/user/add")
    private String addUser(@RequestBody users user){
        commonMethodService.addUser(user);
        return "Successfully Added";
    }

    @PutMapping("/user/update")
    private String updateUser(@RequestParam Long id, @RequestBody users user){
        return commonMethodService.updateUser(id,user);
    }

    @DeleteMapping("/user/delete")
    private String deleteUser(@RequestParam Long id){
        return commonMethodService.deleteUser(id);
    }
}
