package com.lzydmc.bookstore.admincontroller;

import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.common.Constant;
import com.lzydmc.bookstore.exception.BookStoreException;
import com.lzydmc.bookstore.exception.BookStoreExceptionEnum;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.BookImg;
import com.lzydmc.bookstore.model.request.Booksrc;
import com.lzydmc.bookstore.service.BookService;
import com.lzydmc.bookstore.service.BooksrcService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;


//书籍管理模块


@Controller
@RequestMapping("/bookmanage")
public class BookmanageController {

        @Autowired
        BookService bookService;

        @Autowired
        BooksrcService booksrcService;


        //显示所有图书
        @PostMapping("/books")
        @ResponseBody
        public ApiRestResponse listall(HttpSession session){
            return ApiRestResponse.success(bookService.listall());

        }


        //添加书籍
        @PostMapping("/add")
        @ResponseBody
        public ApiRestResponse add(@RequestBody Booksrc booksrc){
                System.out.println(booksrc.toString());
                Book book = new Book();
                BookImg bookImg = new BookImg();
                BeanUtils.copyProperties(booksrc,book);
                BeanUtils.copyProperties(booksrc,bookImg);
                //System.out.println(book.toString()+"/n"+bookImg.toString());
                booksrcService.addbook(book,bookImg);
                return ApiRestResponse.success();
        }

        //删除书籍
        @PostMapping("/del")
        @ResponseBody
        public ApiRestResponse del(Integer id){
                bookService.del(id);
            return ApiRestResponse.success();
        }

        //更新书籍
        @PostMapping("/update")
        @ResponseBody
        public ApiRestResponse update(@RequestBody Booksrc booksrc){
        	    System.out.print(booksrc.toString());
                Book book = new Book();
                BookImg bookImg = new BookImg();
                //对象参数拷贝
                BeanUtils.copyProperties(booksrc,book);
                BeanUtils.copyProperties(booksrc,bookImg);
                booksrcService.update(book,bookImg);
            return ApiRestResponse.success();
        }

        //上传文件
        @PostMapping("/upload/file")
        @ResponseBody
        public ApiRestResponse upload(HttpServletRequest httpServletRequest,
                                      @RequestParam("file") MultipartFile file) {
                String fileName = file.getOriginalFilename();
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //生成文件名称UUID
                UUID uuid = UUID.randomUUID();
                String newFileName = uuid.toString() + suffixName;
                //创建文件
                File fileDirectory = new File(Constant.FILE_UPLOAD_DIR);
                File destFile = new File(Constant.FILE_UPLOAD_DIR +"/"+ newFileName);
                if (!fileDirectory.exists()) {
                        if (!fileDirectory.mkdir()) {
                                throw new BookStoreException(BookStoreExceptionEnum.MKDIR_FAILED);
                        }
                }
                try {
                        file.transferTo(destFile);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                try {
                        return ApiRestResponse
                                .success(getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/images/"
                                        + newFileName);
                } catch (URISyntaxException e) {
                        return ApiRestResponse.error(BookStoreExceptionEnum.UPLOAD_FAILED);
                }
        }

        //获取到文件的地址 还需要开启静态资源映射
        private URI getHost(URI uri) {
                URI effectiveURI;
                try {
                        effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(),
                                null, null, null);
                } catch (URISyntaxException e) {
                        effectiveURI = null;
                }
                return effectiveURI;
        }


        //按名字搜索书籍
        @PostMapping("/searchbook")
        @ResponseBody
        public ApiRestResponse search(String name){
                List<Book> books = bookService.searchByName(name);
                return ApiRestResponse.success(books);
        }



}
