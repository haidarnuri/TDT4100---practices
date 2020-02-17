package com.company;

public class Rectangle {

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Rectangle(){
        this.minX = 0;
        this.minY = 0;
        this.maxX = 0;
        this.minY = 0;
    }

    public int getMinX() { return this.minX;}

    public int getMinY() {
        return this.minY;
    }

    public int getMaxX() {
        return this.maxX;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public int getWidth() {
        return getMaxX() - getMinX();
    }

    public int getHeight(){
        return getMaxY() - getMinY();
    }

    public boolean isEmpty() {
        return (minX==0 && maxX==0 && minY==0 && maxY==0);
    }

    public boolean contains(int x, int y) {
        //skal returnere false dersom rektangelet er tomt.
        if(isEmpty() || x<getMinX() || x>getMaxX() || y<getMinY() || y>getMaxY()){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean contains(Rectangle rect) {
        //sjekker om både min hjørnene og maks hjørnene i rect er inni rektangelet.
        return (contains(rect.getMaxX(),rect.getMaxY()) && (contains(rect.getMinX(),rect.getMinY())));
    }

    public boolean add(int x,int y) {
        //Sjekker om rektangelet mitt er tomt, for så å legge til punktet x og y.
        // minX = maxX= x, minY=maxY=y, bredde = 1 og h�yde = 1
        if(isEmpty()) {
            this.minY = y;
            this.maxY = y;
            this.maxX = x;
            this.minX = x;
            return contains(x,y);
        }
        //Dette gjøres dersom rektangelet mitt kun består av et punkt fra før av.
        else if(getMaxY() == getMinY() && getMaxX()==getMinX()){
            if(x<getMaxX() && y<getMaxY()){
                this.minX = x;
                this.minY = y;

            }
            else if(x<getMaxX() && y>getMaxY()){
                this.minX = x;
                this.maxY = y;
            }

            else if(x>getMaxX() && y>getMaxY()){
                this.maxX = x;
                this.maxY = y;
            }

            else{
                this.maxX = x;
                this.minY = y;
            }
            return contains(x,y);
        }

          //Nye punktet kan være rett over/under, rett til høyre/venstre eller skrått for rektangelet.
	    else if(!contains(x,y)) {
            System.out.println("hei");
	        //Her antar jeg at punktet er under rektangelet mitt.
            if(( (x>getMinX() &&x< getMaxX()) || x == getMaxX() || x==getMinX()) && y >getMaxY()) {

                this.maxY = y;
            }
            //Her antar jeg at punktet er over rektangelet mitt.
            else if(( (x>getMinX() &&x< getMaxX()) || x == getMaxX() || x==getMinX()) && y <getMinY()) {
                this.minY = y;
            }
            //Her antar jeg at punktet er til høyre rektangelet mitt.
            else if((y>getMinY() && y<getMaxY()) || y == getMaxY() || y==getMinY() && x >getMaxX()) {
                System.out.println("hei");
                this.maxX = x;
            }
            //Her antar jeg at punktet er til venstre rektangelet mitt.
            else if((y>getMinY() && y<getMaxY()) || y == getMaxY() || y==getMinY() && x <getMinX()) {
                this.minX = x;
            }
            //Her antar jeg at punktet er skrått opp til venstre for rektangelet mitt.
            else if((x<getMinX() && y<getMinY())) {
                this.minY = y;
                this.minX = x;
            }
            //Her antar jeg at punktet er skrått ned til venstre for rektangelet mitt.
            else if((x<getMinX() && y>getMaxY())) {

                this.maxY = y;
                this.minX = x;
            }
            //Her antar jeg at punktet er skrått opp til høyre for rektangelet mitt.
            else if((x>getMaxX() && y<getMinY())) {
                this.minY = y;
                this.maxX = x;
            }
            //Her antar jeg at punktet er skått ned til høyre for rektangelet mitt.
            else{
                this.maxY = y;
                this.maxX = x;
            }
            return contains(x,y);
        }
        else {
            return contains(x,y);
        }
    }

    public boolean add(Rectangle rect) {

        //Denne løkka tester om det nye rektangelet er inni det gamle. Returnerer false dersom rect er inni rektangelet.
        //Tester også om rect er tom.
        if(contains(rect) || rect.isEmpty()){
            return false;
        }
        //Dersom mitt rektangel er tomt, så endrer jeg det til samme type som rect objektet.
        else if (isEmpty()) {
            this.minX = rect.getMinX();
            this.minY = rect.getMinY();
            this.maxX = rect.getMaxX();
            this.maxY = rect.getMaxY();
            return false;
        }
        //denne løkka blir gjennomført dersom det ny rektangelet ikke er i det gamle.
        else {
            //I de fire neste if løkkene så antar jeg at kun et hjørne er inn mitt rektangel.
            //Dette gjør at vi må strekke et av hjørnene til rektangelet vårt til hjørnet av rect.
            if (!contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && contains(rect.minX, rect.minY)) {
                add(rect.maxX, rect.maxY);
            } else if (!contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                add(rect.minX, rect.maxY);
            } else if (contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                add(rect.minX, rect.minY);
            } else if (!contains(rect.maxX, rect.maxY) && contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                add(rect.maxX, rect.minY);
            }

            //De neste fire løkkene antar at to av hjørnene i rect er inni rektangelet mitt. Derfor trenger vi kun å strekke rektangelet vårt
            // ut til en av sidene eller opp eller ned.
            else if (contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                this.minX = rect.minX;
            } else if (contains(rect.maxX, rect.maxY) && contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                this.minY = rect.minY;
            } else if (!contains(rect.maxX, rect.maxY) && contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && contains(rect.minX, rect.minY)) {
                this.maxX = rect.maxX;
            } else if (!contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && contains(rect.maxX, rect.minY) && contains(rect.minX, rect.minY)) {
                this.maxY = rect.maxY;
            }

            //Neste fire løkkene tester om vårt rektangel må strekkes rett opp når man sammenligner med et rect objekt som er rett over/under eller på høyre/venstre side.
            //Her tenker jeg at vi sammenligner med en rect som ikke har noen felles punkt med rektangelet vårt.
            //Derfor tester jeg først om rect ligger over eller under rektangelet før jeg evt strekker den utover.

            //sammenligner med en rect som ligger rett over eller under.
            else if(!contains(rect) && rect.minX>=getMinX() && rect.maxX<=getMaxX()){
                if(getMaxY()-rect.maxY > getMinY() - rect.maxY){
                    this.minY = rect.minY;
                }
                else if(getMinY()-rect.minY > getMaxY() - rect.minY){
                    this.maxY = rect.maxY;
                }
            }
            //Videre under her antar jeg at rect ikke har noen felles punkt med vårt rektangel.
            //sammenligner med en rect som ligger rett høyre eller venstre.
            else if(!contains(rect) && rect.minY>=getMinY() && rect.maxY<=getMaxY()){
                if(getMaxX()-rect.maxX > getMinX() - rect.maxX){
                    this.minX = rect.minX;
                }
                else if(getMinX()-rect.minX > getMaxX() - rect.minX){
                    this.maxX = rect.maxX;
                }
            }
            //sammenligner med et rect objekt som ligger skrått opp til høyre for vårt rektangel.
            else if(!contains(rect) && (getMaxX()-rect.minX < getMinX() - rect.minX) && (getMinY() - rect.maxY < getMaxY() - rect.maxY)){
                add(rect.maxX,rect.minY);               // this.minY = rect.minY;
               // this.maxX = rect.maxX;
            }

            //sammenligner med et rect objekt som ligger skrått opp til venstre for vårt rektangel.
            else if(!contains(rect) && (getMinX()-rect.maxX < getMaxX() - rect.maxX) && (getMinY() - rect.maxY < getMaxY() - rect.maxY)){
                add(rect.minX,rect.minY);
                //this.minY = rect.minY;
                //this.minX = rect.minX;
            }

            //sammenligner med et rect objekt som ligger skrått ned til høyre for vårt rektangel.
            else if(!contains(rect) && (getMaxX()-rect.minX < getMinX() - rect.minX) && (getMaxY() - rect.minY < getMinY() - rect.minY)){
               add(rect.maxX,rect.maxY);
            //    this.maxY = rect.maxY;
              //  this.maxX = rect.maxX;
            }

            //sammenligner med et rect objekt som ligger skrått ned til venstre for vårt rektangel.
            else{
                add(rect.minX,rect.maxY);
           //     this.maxY = rect.maxY;
             //   this.minX = rect.minX;
            }
            return true;
        }
    }

    //Her skal jeg lage en metode som lager en union av to rektangler.
    //Da bruker jeg add metoden to ganger.
    public Rectangle union(Rectangle rect){
        var newRectangle = new Rectangle();
        //Tester om rect ligger inni rektangelet
        if(contains(rect)){
            newRectangle.add(getMaxX(),getMaxY());
            newRectangle.add(getMinX(),getMinY());
        }
        //Tester om rektangelet ligger inn rect objektet.
        else if (rect.contains(getMaxX(),getMaxY()) && rect.contains(getMinX(),getMinY())){
            newRectangle.add(rect);
        }
        else{
            rect.add(getMaxX(),getMaxY());
            rect.add(getMinX(),getMinY());
            newRectangle.add(rect);
        }
        return newRectangle;
    }

    public Rectangle intersection(Rectangle rect) {
        var newRectangle = new Rectangle();

        if(!isEmpty() && !rect.isEmpty()){
             //Her tenker jeg at rect ligger inn vårt rektangel.
            if (contains(rect)) {
                newRectangle.add(rect);
             }
            //Her tenker jeg at vårt rektangel ligger inn rect.
            else if (rect.contains(getMaxX(), getMaxY()) && rect.contains(getMinX(), getMinY())) {
                newRectangle.add(getMaxX(), getMaxY());
                newRectangle.add(getMinX(), getMinY());
            }

            //De fire neste løkkene tenker jeg at rect har kun et hjørne inni mitt rekangel.
            else if (contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                newRectangle.add(getMinX(), getMinY());
              newRectangle.add(rect.getMaxX(), rect.getMaxY());
            } else if (!contains(rect.maxX, rect.maxY) && contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                newRectangle.add(getMaxX(), getMinY());
                newRectangle.add(rect.getMinX(), rect.getMaxY());
            } else if (!contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && contains(rect.minX, rect.minY)) {
               newRectangle.add(getMaxX(), getMaxY());
               newRectangle.add(rect.getMinX(), rect.getMinY());
            } else if (!contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
               newRectangle.add(getMinX(), getMaxY());
               newRectangle.add(rect.getMaxX(), rect.getMinY());
            }

           //De fire neste løkkene tenker jeg at rect har to hjørner inni mitt rekangel.
            else if (contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                newRectangle.add(rect.getMaxX(), rect.getMaxY());
                newRectangle.add(getMinX(), rect.getMinY());
            } else if (contains(rect.maxX, rect.maxY) && contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && !contains(rect.minX, rect.minY)) {
                newRectangle.add(rect.getMaxX(), rect.getMaxY());
                newRectangle.add(rect.getMinX(), getMinY());
            } else if (!contains(rect.maxX, rect.maxY) && contains(rect.minX, rect.maxY) && !contains(rect.maxX, rect.minY) && contains(rect.minX, rect.minY)) {
                  newRectangle.add(rect.getMinX(), rect.getMinY());
                  newRectangle.add(getMaxX(), rect.getMaxY());
           } else if (!contains(rect.maxX, rect.maxY) && !contains(rect.minX, rect.maxY) && contains(rect.maxX, rect.minY) && contains(rect.minX, rect.minY)) {
               newRectangle.add(rect.getMinX(), rect.getMinY());
              newRectangle.add(rect.getMaxX(), getMaxY());
            }

              //De fire neste løkkene tenker jeg at mitt rektangel at to hjørner inn rect objektet.
            else if (rect.contains(this.maxX, this.maxY) && !rect.contains(this.minX, this.maxY) && rect.contains(this.maxX, this.minY) && !rect.contains(this.minX, this.minY)) {
                newRectangle.add(getMaxX(), getMaxY());
                newRectangle.add(rect.getMinX(), getMinY());

             } else if (rect.contains(this.maxX, this.maxY) && rect.contains(this.minX, this.maxY) && !rect.contains(this.maxX, this.minY) && !rect.contains(this.minX, this.minY)) {
                newRectangle.add(getMaxX(), getMaxY());
                newRectangle.add(getMinX(), rect.getMinY());

            } else if (!rect.contains(this.maxX, this.maxY) && rect.contains(this.minX, this.maxY) && !rect.contains(this.maxX, this.minY) && rect.contains(this.minX, this.minY)) {
                newRectangle.add(getMinX(), getMinY());
               newRectangle.add(rect.getMaxX(), getMaxY());

            } else if (!rect.contains(this.maxX, this.maxY) && !rect.contains(this.minX, this.maxY) && rect.contains(this.maxX, this.minY) && rect.contains(this.minX, this.minY)) {
               newRectangle.add(getMinX(), getMinY());
               newRectangle.add(getMaxX(), rect.getMaxY());
           }
            return newRectangle;
         }

        //Sjekker om begge rektanglene er tomme.
        else if(isEmpty() && rect.isEmpty()){
             return newRectangle;
           }

       else {
             //Dette gjøres hvis en av dem er tomme.
             if(isEmpty()){
                 newRectangle.add(rect);
             }
            else{
                 newRectangle.add(getMinX(),getMinY());
                newRectangle.add(getMaxX(),getMaxY());
            }
           return newRectangle;
          }
    }

    public boolean intersects(Rectangle rect){
        //Sjekker om rect objektet har noen hjørner inni mitt rektangel.
        if(contains(rect.maxX, rect.maxY) || contains(rect.minX, rect.maxY) || contains(rect.maxX, rect.minY) || contains(rect.minX, rect.minY)){
            return true;
        }
        //Sjekker om mitt rektangel har noen hjørner i rect objektet.
        else return (rect.contains(this.maxX, this.maxY) || rect.contains(this.minX, this.maxY) || rect.contains(this.maxX, this.minY) || rect.contains(this.minX, this.minY));
    }

    @Override
    public String toString() {
        return "Verdiene dine er følgende: maxX = " + getMaxX()+" maxY = "+getMaxY() + "  minX = " + getMinX()+" minY = "+getMinY();
        }



}











