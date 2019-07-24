package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Paddy
 * @time 2019-07-23 21:53
 * @class describe
 */
@Entity(tableName = "x2_questions")
public class Questions {
    @PrimaryKey
    @ColumnInfo
    private int questionid;
    @ColumnInfo
    private int questiontype;
    @ColumnInfo
    private int question;
    @ColumnInfo
    private int questiontitle;
    @ColumnInfo
    private int questionuserid;
    @ColumnInfo
    private String questionusername;
    @ColumnInfo
    private String questionlastmodifyuser;
    @ColumnInfo
    private String questionselect;
    @ColumnInfo
    private int questionselectnumber;
    @ColumnInfo
    private String questionanswer;
    @ColumnInfo
    private String questiondescribe;
    @ColumnInfo
    private String questionknowsid;
    @ColumnInfo
    private int questioncreatetime;
    @ColumnInfo
    private int questionstatus;
    @ColumnInfo
    private String questionhtml;
    @ColumnInfo
    private int questionparent;
    @ColumnInfo
    private int questionsequence;
    @ColumnInfo
    private int questionlevel;
    @ColumnInfo
    private int oneobjecttype;
    @ColumnInfo
    private int twoobjecttype;
    @ColumnInfo
    private int subjecttype;
    @ColumnInfo
    private int sectiontype;
    @ColumnInfo
    private String questionarticle;
    @ColumnInfo
    private String articletitle;
    @ColumnInfo
    private String mathfoundation;
    @ColumnInfo
    private int views;
    @ColumnInfo
    private int comments;
    @ColumnInfo
    private String discusstime;
    @ColumnInfo
    private int discussmark;
    @ColumnInfo
    private int readArticleId;
    @ColumnInfo
    private String articleContent;
    @ColumnInfo
    private int questionNumber;
    @ColumnInfo
    private int questionNumber1;
    @ColumnInfo
    private String offer;
    @ColumnInfo
    private int isoffer;
    @ColumnInfo
    private int isOG;
    @ColumnInfo
    private int questionNumber2;
    @ColumnInfo
    private int questionNumber3;
    @ColumnInfo
    private int questionNumber4;
    @ColumnInfo
    private int questionNumber5;
    @ColumnInfo
    private int questionNumber6;


    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(int questiontype) {
        this.questiontype = questiontype;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getQuestiontitle() {
        return questiontitle;
    }

    public void setQuestiontitle(int questiontitle) {
        this.questiontitle = questiontitle;
    }

    public int getQuestionuserid() {
        return questionuserid;
    }

    public void setQuestionuserid(int questionuserid) {
        this.questionuserid = questionuserid;
    }

    public String getQuestionusername() {
        return questionusername;
    }

    public void setQuestionusername(String questionusername) {
        this.questionusername = questionusername;
    }

    public String getQuestionlastmodifyuser() {
        return questionlastmodifyuser;
    }

    public void setQuestionlastmodifyuser(String questionlastmodifyuser) {
        this.questionlastmodifyuser = questionlastmodifyuser;
    }

    public String getQuestionselect() {
        return questionselect;
    }

    public void setQuestionselect(String questionselect) {
        this.questionselect = questionselect;
    }

    public int getQuestionselectnumber() {
        return questionselectnumber;
    }

    public void setQuestionselectnumber(int questionselectnumber) {
        this.questionselectnumber = questionselectnumber;
    }

    public String getQuestionanswer() {
        return questionanswer;
    }

    public void setQuestionanswer(String questionanswer) {
        this.questionanswer = questionanswer;
    }

    public String getQuestiondescribe() {
        return questiondescribe;
    }

    public void setQuestiondescribe(String questiondescribe) {
        this.questiondescribe = questiondescribe;
    }

    public String getQuestionknowsid() {
        return questionknowsid;
    }

    public void setQuestionknowsid(String questionknowsid) {
        this.questionknowsid = questionknowsid;
    }

    public int getQuestioncreatetime() {
        return questioncreatetime;
    }

    public void setQuestioncreatetime(int questioncreatetime) {
        this.questioncreatetime = questioncreatetime;
    }

    public int getQuestionstatus() {
        return questionstatus;
    }

    public void setQuestionstatus(int questionstatus) {
        this.questionstatus = questionstatus;
    }

    public String getQuestionhtml() {
        return questionhtml;
    }

    public void setQuestionhtml(String questionhtml) {
        this.questionhtml = questionhtml;
    }

    public int getQuestionparent() {
        return questionparent;
    }

    public void setQuestionparent(int questionparent) {
        this.questionparent = questionparent;
    }

    public int getQuestionsequence() {
        return questionsequence;
    }

    public void setQuestionsequence(int questionsequence) {
        this.questionsequence = questionsequence;
    }

    public int getQuestionlevel() {
        return questionlevel;
    }

    public void setQuestionlevel(int questionlevel) {
        this.questionlevel = questionlevel;
    }

    public int getOneobjecttype() {
        return oneobjecttype;
    }

    public void setOneobjecttype(int oneobjecttype) {
        this.oneobjecttype = oneobjecttype;
    }

    public int getTwoobjecttype() {
        return twoobjecttype;
    }

    public void setTwoobjecttype(int twoobjecttype) {
        this.twoobjecttype = twoobjecttype;
    }

    public int getSubjecttype() {
        return subjecttype;
    }

    public void setSubjecttype(int subjecttype) {
        this.subjecttype = subjecttype;
    }

    public int getSectiontype() {
        return sectiontype;
    }

    public void setSectiontype(int sectiontype) {
        this.sectiontype = sectiontype;
    }

    public String getQuestionarticle() {
        return questionarticle;
    }

    public void setQuestionarticle(String questionarticle) {
        this.questionarticle = questionarticle;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

    public String getMathfoundation() {
        return mathfoundation;
    }

    public void setMathfoundation(String mathfoundation) {
        this.mathfoundation = mathfoundation;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getDiscusstime() {
        return discusstime;
    }

    public void setDiscusstime(String discusstime) {
        this.discusstime = discusstime;
    }

    public int getDiscussmark() {
        return discussmark;
    }

    public void setDiscussmark(int discussmark) {
        this.discussmark = discussmark;
    }

    public int getReadArticleId() {
        return readArticleId;
    }

    public void setReadArticleId(int readArticleId) {
        this.readArticleId = readArticleId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getQuestionNumber1() {
        return questionNumber1;
    }

    public void setQuestionNumber1(int questionNumber1) {
        this.questionNumber1 = questionNumber1;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public int getIsoffer() {
        return isoffer;
    }

    public void setIsoffer(int isoffer) {
        this.isoffer = isoffer;
    }

    public int getIsOG() {
        return isOG;
    }

    public void setIsOG(int isOG) {
        this.isOG = isOG;
    }

    public int getQuestionNumber2() {
        return questionNumber2;
    }

    public void setQuestionNumber2(int questionNumber2) {
        this.questionNumber2 = questionNumber2;
    }

    public int getQuestionNumber3() {
        return questionNumber3;
    }

    public void setQuestionNumber3(int questionNumber3) {
        this.questionNumber3 = questionNumber3;
    }

    public int getQuestionNumber4() {
        return questionNumber4;
    }

    public void setQuestionNumber4(int questionNumber4) {
        this.questionNumber4 = questionNumber4;
    }

    public int getQuestionNumber5() {
        return questionNumber5;
    }

    public void setQuestionNumber5(int questionNumber5) {
        this.questionNumber5 = questionNumber5;
    }

    public int getQuestionNumber6() {
        return questionNumber6;
    }

    public void setQuestionNumber6(int questionNumber6) {
        this.questionNumber6 = questionNumber6;
    }
}
