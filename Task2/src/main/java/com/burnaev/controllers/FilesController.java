package com.burnaev.controllers;

import com.burnaev.forms.CreateFileForm;
import com.burnaev.models.FileInfo;
import com.burnaev.models.Sort;
import com.burnaev.models.User;
import com.burnaev.repositories.FilesInfoRepository;
import com.burnaev.services.AuthenticationService;
import com.burnaev.services.FilesService;
import com.burnaev.services.UsersService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class FilesController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private CommonData commonData;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private FilesService filesService;

    @GetMapping("/files")
    public String showFiles(@ModelAttribute("model") ModelMap modelMap,
                              Authentication authentication,
                            @RequestParam(value = "sort", defaultValue = "NAME_UP") String sort){
        commonData.dataToModel(modelMap, authentication);
        User user = authenticationService.getUserByAuthentication(authentication);
        modelMap.addAttribute("user", user);
        List<FileInfo> files = filesService.getSortedFiles(user.getId(), Sort.valueOf(sort));
        modelMap.addAttribute("files", files);
        modelMap.addAttribute("sorted", sort);
        return "file_pages/files";
    }

    @GetMapping("/open_file")
    @SneakyThrows
    public String getOpenFilePage(@ModelAttribute("model") ModelMap modelMap,
                                  Authentication authentication,
                                  @RequestParam(value = "id") Long id){
        commonData.dataToModel(modelMap, authentication);
        FileInfo fileInfo = filesService.getFileById(id);
        FileInputStream fileInputStream = new FileInputStream(fileInfo.getUrl());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String text = "";
        String line;
        while ((line = bufferedReader.readLine()) != null){
            text += line;
        }
        modelMap.addAttribute("text", text);

        return "file_pages/open_file";
    }

    @GetMapping("/create_file")
    public String getCreateFilePage(@ModelAttribute("model") ModelMap modelMap,
                                    Authentication authentication){
        commonData.dataToModel(modelMap, authentication);
        return "file_pages/create_file";
    }

    @PostMapping("/create_file")
    public String createFile(@ModelAttribute CreateFileForm createFileForm,
                                   Authentication authentication,
                                   @ModelAttribute("model") ModelMap modelMap) {
        commonData.dataToModel(modelMap, authentication);
        User user = authenticationService.getUserByAuthentication(authentication);
        filesService.createFile(createFileForm, user.getId());
        return "redirect:/files";
    }

    @PostMapping("delete_file")
    public String deleteFile(@RequestParam(value = "id") Long fileId){
        filesService.delete(fileId);
        return "redirect:/files";
    }

    @GetMapping("/search")
    public String getSearchPage(@ModelAttribute("model") ModelMap modelMap,
                                Authentication authentication,
                                @RequestParam("search") String search) {
        commonData.dataToModel(modelMap, authentication);
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            modelMap.addAttribute("user", user);
        }
        modelMap.addAttribute("search", search);
        List<FileInfo> fileInfoList = filesService.findByName(search);
        modelMap.addAttribute("fileInfoList", fileInfoList);
        return "file_pages/search";
    }
}
