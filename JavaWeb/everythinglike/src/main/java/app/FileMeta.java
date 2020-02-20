package app;

import util.PinyinUtil;
import util.Util;

import java.io.File;
import java.util.Date;

public class FileMeta {
    //文件名称
    private String name;
    //文件所在的父目录的路径
    private String path;
    //文件大小
    private Long size;//基本数据类型new出来为0，包装类型new出来为null
    //文件上次修改时间
    private Date lastModified;
    //是否是文件夹
    private Boolean isDirectory;
    //给客户端控件使用，和app.fxml中定义的名称要一致
    private String sizeText;
    //和aoo.fxml定义的一致
    private String lastModifiedText;
    //文件名拼音
    private String pinyin;
    //文件名拼音首字母
    private String pinyinFirst;

    //通过文件设置属性
    public FileMeta(File file){
        this(file.getName(),file.getParent(),file.isDirectory(),file.length(),new Date(file.lastModified()));
    }

    //通过数据库获取的数据设置FileMeta
    public FileMeta(String name, String path, Boolean isDirectory, long size, Date lastModified){
        this.name=name;
        this.path=path;
        this.isDirectory=isDirectory;
        this.size=size;
        this.lastModified=lastModified;
        if(PinyinUtil.containChinese(name)){
            String[] pinyins = PinyinUtil.get(name);
            pinyin = pinyins[0];
            pinyinFirst = pinyins[1];
        }
        //客户端表格控件文件大小、文件上次修改时间的设置
        sizeText = Util.parseSize(size);
        lastModifiedText = Util.parseDate(lastModified);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public String getLastModifiedText() {
        return lastModifiedText;
    }

    public void setLastModifiedText(String lastModifiedText) {
        this.lastModifiedText = lastModifiedText;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinFirst() {
        return pinyinFirst;
    }

    public void setPinyinFirst(String pinyinFirst) {
        this.pinyinFirst = pinyinFirst;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public void setDirectory(Boolean directory) {
        isDirectory = directory;
    }
}
