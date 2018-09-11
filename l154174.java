//Author Maaz Elahi
//Roll.no: 15l-4174
//Section: B

//The following code is for Developers Biodata

//abstract class
abstract class Developers{
	
	int idNumber;
	String n;
	int salary;
	String designation;
	int status;
	
	
	//non abstract methods
	public Developers(int idNumber,String n,int salary,String designation,int status){
		
		this.idNumber=idNumber;
		this.salary=salary;
		this.n=n;
		this.designation=designation;
		this.status=status;
	}
	
	public void printStatus()
	{
	    if(this.status==1)
	    {
	        this.active();
	    }
	    else
	    {
	        this.inactive();
	    }
	}
	
	public void active(){
		System.out.println("This is employee is currently active!");
	}
	
	public void inactive(){
		System.out.println("This is employee is currently inactive!");
	}
	
	
	//abstract method
	public abstract void onVacations();
	
}

interface webDeveloper {
	
	public abstract void webDevelopmentPlatforms();
	public abstract void printWebLanguages();
}

interface androidDeveloper {
	
	public abstract void androidDevelopmentPlatforms();
	public abstract void printAndroidLanguages();
}


class Coders extends Developers implements webDeveloper,androidDeveloper {
    
    //non static nested class
    class companyProjects{
        
        int web_projects_completed;
        int android_projects_completed;
        
        
        int web_projects_pending;
        int android_projects_pending;
        
        public void companyProjects()
        {
            web_projects_completed=0;
            android_projects_completed=0;
            web_projects_pending=0;
            android_projects_pending=0;    
        }
        
        public int getCWP()
        {
            return web_projects_completed;
        }
        
        public int getCAP()
        {
            return android_projects_completed;
        }
        
        public void setCWP(int projects)
        {
            web_projects_completed=projects;
        }
        
        public void setCAP(int projects)
        {
            android_projects_completed=projects;
        }
    }
    
    Coders(int idNumber,int salary,String n,String designation,int status){
        
        super(idNumber,n,salary,designation,status);
    }
    
    //static nested class
    static class Experts{
        
        String[] ranks;
        
        Experts(){
            ranks=new String[4];
        }
        
        public void showRanks(){
            System.out.println("\n");
            for (int i=0;i<3;i++){
                int j=i+1;
                System.out.println(j+". "+ranks[i]+"\n");
            }
        }
        
        public void insertRank(String name,int rankingNumber){
            ranks[rankingNumber-1]=name;
        }
    }
    
    public void webDevelopmentPlatforms()
    {
        System.out.println("Following are the famous Web Development Platforms: \n");
        System.out.println("1. WordPress\n");
        System.out.println("2. Joomla\n");
        System.out.println("3. Open Cart\n");
    }
    
    public void androidDevelopmentPlatforms()
    {
        System.out.println("Following are the famous Android Development Platforms: \n");
        System.out.println("1. Gimbal Context Aware\n");
        System.out.println("2. Vuforia Augmented Reality\n");
        System.out.println("3. AppMachine\n");
    }
    
    public void printWebLanguages()
    {
        System.out.println("Following are the famous Web Development Languages: \n");
        System.out.println("1. HTML\n");
        System.out.println("2. Javascript\n");
        System.out.println("3. CSS\n");
    }
    
    public void printAndroidLanguages()
    {
        System.out.println("Following are the famous Android Development Languages: \n");
        System.out.println("1. Java\n");
        System.out.println("2. Kotlin\n");
        System.out.println("3. C++/C#\n");
    }
    
	public void onVacations(){
		System.out.println("This employee is on vacations\n");
	}
}

public class myMainClass{
    
    public static void main(String args[]){
	
	    Coders c1 = new Coders(1,50000,"John Smith","Senior Developer",1);
	    
	    //interface class functions
	    c1.webDevelopmentPlatforms();
	    c1.printAndroidLanguages();
	    c1.printStatus();
	    
	    //abstract parent class functions
	    c1.onVacations();
	    
	    
	    //static nested class and it's fuctions
	    Coders.Experts ranks = new Coders.Experts();
	    ranks.insertRank("Andrew Smith",1);
	    ranks.insertRank("Alan Mark",2);
	    ranks.showRanks();
	    Coders.companyProjects data = c1.new companyProjects();
	    data.setCWP(2);
System.out.println("The completed web development projects are : "+data.getCWP());
        data.setCAP(4);
System.out.println("The completed android development projects are : "+data.getCAP());
	    
    }    
    
}
