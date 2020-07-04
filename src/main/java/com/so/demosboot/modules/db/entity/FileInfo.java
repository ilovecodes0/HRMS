package com.so.demosboot.modules.db.entity;
import org.hibernate.validator.constraints.Length;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

public class FileInfo extends BaseEntity<FileInfo>{

        private static final long serialVersionUID = 1L;
        private String id;
        private String title;		// 文档标题
        private String content;		// 文档内容
        private String time;        // 文档发布时间
        private String author;  //zuo zhe
        private String type;        //文档类别

        public FileInfo() {
            super();
        }

        public FileInfo(String id){
            this.id = id;
        }

        public String getId() {
            return id;
        }


        public void setId(String id) {
            this.id = id;
        }


        @Length(min=1, max=20, message="文档标题长度必须介于 1 和 20 之间")
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Length(min=0, max=10000, message="文档信息长度必须介于 0 和 10000 之间")
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Length(min=0, max=40, message="时间长度必须介于 0 和 40 之间")
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setType(String type) {
        this.type = type;
        }
        public String getType() {return type; }

        public void setAuthor(String author) {
        this.author = author;
    }
        public String getAuthor() {return author; }

}
