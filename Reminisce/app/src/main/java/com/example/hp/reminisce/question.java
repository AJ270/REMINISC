package com.example.hp.reminisce;

public class question {
    private int mtextidforquestion;
    private int mimageidforquestion;
    private int manswerid;


    public question(int textidforquestion, int answer, int imageidforquestion)
    {
        mtextidforquestion=textidforquestion;
        manswerid=answer;//manswer is returned by the function
        mimageidforquestion=imageidforquestion;
    }

    public int getMtextidforquestion() {
        return mtextidforquestion;
    }

    public void setMtextidforquestion(int mtextidforquestion) {
        this.mtextidforquestion = mtextidforquestion;
    }

    public int getManswerid() {
        return manswerid;
    }

    public void setManswerid(int manswerid) {
        this.manswerid = manswerid;
    }

    public int getMimageidforquestion() {
        return mimageidforquestion;
    }


    public void setMimageidforquestion(int mimageidforquestion) {
        this.mimageidforquestion = mimageidforquestion;
    }

}
