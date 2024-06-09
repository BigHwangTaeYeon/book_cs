public class Window extends Participant {
    private boolean bColsed = true;

    public Window(Mediator mediator) {
        super(mediator);
    }

    public void open() {
        if (!bColsed)
            return;
        
        bColsed = false;

        mediator.participantChanged(this);
    }

    public void close() {
        if (bColsed)
            return;

        bColsed = true;

        mediator.participantChanged(this);
    }

    public boolean isClosed() {
        return bColsed;
    }

    @Override
    public String toString() {
        if (bColsed)
            return "# 창문 : 닫힘";
        else
            return "# 창문 : 열림";
    }
}
