import java.io.* ;
class FileSplitter {
	public static void main(String args[]) throws IOException{
		Console cn = System.console();
		System.out.print("Enter Your File Name : ") ;
		String a1 = cn.readLine();
		a1.trim();
		FileInputStream fi = new FileInputStream(a1);
		System.out.print("Enter Destination File Size : ") ;
		long a2 = Long.parseLong(cn.readLine());
		int ch ;
		File file1 = new File(a1);
		long j = file1.length() / a2 ;
		if(file1.length()%a2 != 0 )
			j++ ;
		for(long i = 1; i <= j ; i++ ){
				
			long count = 1 ;
			String addon = i+"." ;
			String temp = a1 ;
			String fName = a1.replace("." ,addon) ;
			a1 = temp ;
			File ff = new File(fName);
			if(!ff.exists())
				ff.createNewFile();
			FileOutputStream fo = new FileOutputStream(ff);
			while((ch=fi.read()) != -1  && count <= a2 ){
					fo.write(ch);
					count++ ;
			}
			System.out.println("completed");
			fo.close();
		}
		fi.close();
		File nf = new File(a1);
			nf.delete();
	}
}
