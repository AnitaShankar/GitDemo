package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///count the number of names starting with alphabet A in the list 
		
		//with regular java code ----------
		
		/*ArrayList<String> names= new ArrayList<String>();
		names.add("Abhi");
		names.add("Ani");
		names.add("Jyo");
		names.add("Dan");
		names.add("Aru");
		int count=0;
		
		for(int i=0;i<names.size();i++) 
			
		{
			String name = names.get(i);
			if(name.startsWith("A"))
			{
				count++;
			}
		}
		
		System.out.println(count);*/
		
		
		//java with streams -------------
		
		/*ArrayList<String> names= new ArrayList<String>();
		names.add("Abhi");
		names.add("Ani");
		names.add("Jyo");
		names.add("Dan");
		names.add("Aru");
		//-> Lambda expression 
		Long result= names.stream().filter(a->a.startsWith("A")).count();
		System.out.println(result);*/
		
		
		//storing the values in streams instead of collections 
		
		Long result1=Stream.of("Abhi","Ani","Jyo","Dan","Aru").filter(i->
		{
			i.startsWith("A");
			return true;
		}
		).count();
		System.out.println(result1);
		
		
		///printing all the names of ArrayList 
		
		/*ArrayList<String> names= new ArrayList<String>();
		names.add("Abhi");
		names.add("Ani");
		names.add("Jyo");
		names.add("Dan");
		names.add("Aru");
		
		names.stream().filter(s->s.length()>2).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.length()>2).limit(3).forEach(s->System.out.println(s));*/
		
		
		///converting the names which have last latter as "a to UpperCase
		
		Stream.of("Anita","Amina","lalika","Abhi","shalu").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		
		///conevrting array to arraylist and printing the names which strats with letter "a to uppercase
		
		List<String> name=Arrays.asList("Aphi","Ani","Jyo","Dan","Airu");
		name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		
		//Merging the two array lists and sorting the values
		
		ArrayList<String> names1= new ArrayList<String>();
		names1.add("Abhi");
		names1.add("Ani");
		names1.add("Jyo");
		names1.add("Dan");
		names1.add("Aru");
		
		
		List<String> names2=Arrays.asList("Swa","Dee","Sou","Dad","Mom");
		
		Stream<String> newNames=Stream.concat(names1.stream(), names2.stream());
		newNames.sorted().forEach(s->System.out.println(s));
		
		System.out.println("******************************************************");
		
		
		//checking whether particular name is present and checking its true or false
		
		ArrayList<String> names3= new ArrayList<String>();
		names3.add("Abhi");
		names3.add("Ani");
		names3.add("Jyo");
		names3.add("Dan");
		names3.add("Aru");
		
		
		List<String> names4=Arrays.asList("Swa","Dee","Sou","Dad","Mom");
		
		Stream<String> Result1=Stream.concat(names3.stream(), names4.stream());
		boolean flag=Result1.anyMatch(s->s.equalsIgnoreCase("Swa"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
		
		///Collect method - collects the results and converts it to any List
		
		
		List<String> ls = Stream.of("Anita","Amina","lalika","Abhi","shalu").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println(ls.get(0));
		
		///printing the unique numbers of array and sorting it
		
		List<Integer> values=Arrays.asList(1,2,6,3,6,2,8,9,0);
		values.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("----------");
		//printing the 3rd index from sorted values
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
		
	}

}
