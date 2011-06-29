package Sample;

/**********************************************************
 OrgChart 1.0 (24.10.2000)
 Applet de afisare structuri organizationale.
 Realizat de Skippy/RoWD, <rowd@go.ro>.
 Acest program este distribuit sub licenta GNU.
 Informatii suplimentare: http://rowd.go.ro/proiecte
 **********************************************************/

import java.awt.*; //clasa grafica awt
import java.applet.*; //clasa applet
import java.util.*; //pentru diverse functii utilitare
import java.lang.*; //idem

public class orgChart extends Applet //clasa de baza
{
    Chart chart = null; //obiectul Chart
    errorCanvas errCanv = null; //obiectul care afiseaza erorile
    ScrollPane scrollPane = null; //panou prevazut cu scrolling
    String nodes_s = null, error_msg = null, s = null; //obiecte string
    int nodes=0,i=0,j=0; //obiecte integer
    StringTokenizer tk=null; //pentru impartirea parametrilor dupa '|'

    int maxDepth=0; //adincimea maxima; necesara pentru calcularea dimeniunii panoului
    int cellWidth=130; //definire zona de incadrare a unei celule, pentru desenare
    int cellHeight=50; //important: doar calcularea coordonatelor tine seama de ea,
                       //nu si desenarea propriu-zisa a celulelor

    String[][] ndata=null; //aici depozitam datele
    //array:                      param:
    //        0=id (1+)           X
    //        1=text              X
    //        2=parent id         X
    //        3=first son id      X
    //        4=next brother id   X
    //        5=depth level (0+)  X
    //        6=coordX            -
    //        7=coordY            -
    //        8=span              -
    
    public void init() //constructor
    {
        
        nodes_s = getParameter("nodes"); //citeste numarul de noduri
        if (nodes_s==null) //daca nu exista parametrul
        {
            error_msg="Need parameter 'NODES' [1]";
        }
        else
        if (nodes_s.equals("")) //daca nu contine nimic
        {
            error_msg="Need parameter 'NODES' [2]";
        }
        
        try
        {
            nodes = Integer.parseInt(nodes_s);
        }
        catch (NumberFormatException e) //daca nu e un numar
        {
            error_msg="Parameter 'NODES' must be numeric [3]";
        }
        
        ndata = new String[nodes+1][9]; //defineste matricea de date
        for (i=1;i<nodes+1;i++) //o parcurgem in sens crescator
        {
            s=getParameter(""+i); //citim parametrul i
            if (s==null) //daca nu exista
            {
                error_msg="Need parameter '"+i+"' [4]";
                break;
            }
            else
            if (s.equals("")) //daca nu contine nimic
            {
                error_msg="Need parameter '"+i+"' [5]";
                break;
            }
            tk=new StringTokenizer(s,"|",false); //spargem informatia dupa |
            for (j=0;tk.hasMoreTokens()&&j<6;j++) //parcurgem si memoram bucatile
            {
                s=tk.nextToken();
                ndata[i][j]=s;
            }
            if (j<5) //nu erau destule bucati
            {
                error_msg="Wrong value for parameter '"+i+"' (only "+j+" components) [6]";
                break;
            }
            for (j=6;j<9;j++) ndata[i][j]="1"; //completam restul cimpurilor cu 1 deocamdata
        }

        if (error_msg==null) //daca nu s-a dat nici un mesaj de eroare
        {
            //trebuie parcursa matricea si calculate cimpurile 6-8, care contin
            // 6,7=coordonatele x,y de afisare a celulei, 
            // 8=ce latime maxima, in celule, are intregul corp de copii ai celulei

            // deocamdata parcurgem recursiv o data, generam cimpul 8 si aflam maxDepth
            makeSpan(1); //incep la celula 1
            // a doua parcurgere, generam coordonatele
            setCoords(1,0);
            // truchiere texte ca sa nu iasa din dreptunghiuri
            for (i=1;i<ndata.length;i++)
                ndata[i][1]=fixText(ndata[i][1]);

            scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED); //creare panou
            add(scrollPane); //introducere in desen
            scrollPane.setBounds(0,0,610,390); //stabilim marimea de afisare

            chart = new Chart(ndata,cellWidth,cellHeight,maxDepth); //creare obiect Chart
            scrollPane.add(chart); //introducem Chart in panou
        }
        else
        {
            errCanv = new errorCanvas(error_msg); //cream obiectul pentru afisare erori
            add(errCanv); //il desenam
        }
    }

    private String fixText(String origText)
    {
        Font font = new Font("Dialog",Font.PLAIN,11);
        FontMetrics fm = getFontMetrics(font);
        if (fm.stringWidth(origText)>114)
        {
            while (fm.stringWidth(origText+"...")>114)
                origText=origText.substring(0,origText.length()-1);
            return origText+"...";
        }
        return origText;
    }

    private void makeSpan(int id) //calculare latimi maxime
    {
        int span=0; //latimea pentru celula asta e 0 deocamdata
        int son_id=Integer.parseInt(ndata[id][3]); // cine e primul fiu

        while (son_id!=0) //atita vreme cit mai sint fii
        {
            makeSpan(son_id); // calculeaza latimea recursiv pentru fiu
            span=span+Integer.parseInt(ndata[son_id][8]); //creste latimea acestei celule cu latimea fiului
            son_id=Integer.parseInt(ndata[son_id][4]); // trece la urmatorul fiu
        }
        if (span==0) ndata[id][8]="1"; //daca n-a avut fii punem latime 1
        else ndata[id][8]=span+""; //altfel punem latimea calculata
        if (Integer.parseInt(ndata[id][5])>maxDepth) maxDepth=Integer.parseInt(ndata[id][5]);
        //daca adincimea locala e mai mare decit cea mai mare inregistrata o retinem
    }

    private void setCoords(int id,int start_off) //calculare coordonate
    {
        int offset=start_off; //distanta fata de marginea din stinga
        int temp=0; //variabila temporara
        int son_id=Integer.parseInt(ndata[id][3]); // cine e primul fiu

        // coordonatele pentru celula asta
        // la verticala e usor, luam adincimea locala*inaltimea unei celule
        temp=Integer.parseInt(ndata[id][5])*cellHeight; 
        ndata[id][7]=temp+"";
        // la orizontala trebuie sa centram pe latimea calculata, si adaugam distanta pina la margine
        temp=offset+(Integer.parseInt(ndata[id][8])-1)*cellWidth/2;
        ndata[id][6]=temp+"";

        while (son_id!=0) //cita vreme mai are fii
        {
            setCoords(son_id,offset); // calculeaza pentru fiu si toti fiii lui
            offset=offset+Integer.parseInt(ndata[son_id][8])*cellWidth; //recalculam distanta pina la margine
            son_id=Integer.parseInt(ndata[son_id][4]); // urmatorul fiu
        }
    }
}

class Chart extends Canvas
{
    
    private String[][] nodes = null; //matricea in care preluam datele
    private int maxX=0; //latimea desenului
    private int maxY=0; //inaltimea desenului

    public Chart(String[][] n_data,int cellWidth,int cellHeight,int maxDepth)
    {
        if (n_data==null) //daca nu primim nimic facem o matrice de baza
        {
            nodes = new String[2][9];
            nodes[1][0]="0";
            nodes[1][1]="0";
            nodes[1][2]="0";
            nodes[1][3]="0";
            nodes[1][4]="0";
            nodes[1][5]="0";
            nodes[1][6]="0";
            nodes[1][7]="0";
            nodes[1][8]="1";
        }
        else nodes=n_data; //altfel folosim ce primim
        maxX=cellWidth*Integer.parseInt(nodes[1][8])+30; //calculam latimea
        maxY=cellHeight*maxDepth+45; //...si inaltimea desenului
        setBackground(new Color(204,204,204)); //culoarea fundalului
    }

    public Dimension getPreferredSize() {
        return new Dimension(maxX,maxY); //stabilim marimea desenului
    }
    
    private void drawText(int x,int y,String s,Graphics g) //desenare text centrat in celula
    {
        Font font = new Font("Dialog",Font.PLAIN,11);
        g.setFont(font);
        g.setColor(new Color(255,255,255));
        FontMetrics fm = g.getFontMetrics(g.getFont());
        int textWidth = fm.stringWidth(s);
        int textHeight = fm.getHeight();
        g.drawString(s,x+(110-textWidth)/2+6,y+14);
    }

    private void drawCell(int x,int y,String s,Graphics g) //desenare celula
    {
        g.setColor(new Color(255,255,255));
        g.drawRect(x,y,120,20);
        g.setColor(new Color(0,0,255));
        g.fillRect(x+1,y+1,119,19);
        drawText(x,y,s,g);
    }

    //desenare legatura intre tata si fiu, neaparat in aceasta ordine!
    private void drawLink(int x1,int y1,int x2,int y2,Graphics g) 
    {
        int xp=x1+61,xs=x2+61;
        int yp=y1+21,ys=y2-1;
        int vert=Math.abs(ys-yp)/2;

        g.setColor(new Color(255,0,0));
        g.drawLine(xp,yp,xp,yp+vert);
        g.drawLine(xs,ys-vert,xs,ys);
        if (xp!=xs)
            g.drawLine(xp,yp+vert,xs,ys-vert);
    }

    private void chartDisplay(Graphics g) //parcurgere matrice si afisare celule
    {
        int i=0;

        for (i=1;i<nodes.length;i++)
        {
            drawCell(15+Integer.parseInt(nodes[i][6]),15+Integer.parseInt(nodes[i][7]),nodes[i][1],g);
            if (!nodes[i][2].equals("0"))
                drawLink(15+Integer.parseInt(nodes[Integer.parseInt(nodes[i][2])][6]),15+Integer.parseInt(nodes[Integer.parseInt(nodes[i][2])][7]),15+Integer.parseInt(nodes[i][6]),15+Integer.parseInt(nodes[i][7]),g);
        }
    }

    public void paint(Graphics g) //procedura principala de desenare
    {
        chartDisplay(g);
    }
}

class errorCanvas extends Canvas //clasa pentru afisare erori
{
    private String ermsg=null;

    public Dimension getPreferredSize() //stabilim marimea de afisare
    {
        return new Dimension(610, 390);
    }
                
    public errorCanvas(String em) //constructor
    {
        if (em==null) ermsg="Unknown error [?1]";
        else
        if (em.equals("")) ermsg="Unknown error [?2]";
        else
        ermsg=em;
    }
    
    public void paint(Graphics g) //afisam eroarea
    {
        setBackground(Color.white);
        Font font = new Font("Dialog",Font.BOLD,11);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Error:",10,10);
        g.setColor(Color.red);
        g.drawString(ermsg,45,10);
    }
}

