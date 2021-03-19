import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemService {
	public Set<Item> collectAllItems(List<String> data) throws PriceException, GradeMismatchException, EssentialCommodityException{
		Item[] a=new Item[data.size()];
		List<Item> iList=new ArrayList<Item>();
		for(int i=0;i<data.size();i++){		
			String[] inArr=data.get(i).split(",");
			boolean repeated=false;
			for(int j=0;j<iList.size();j++){
				Integer v1 = new Integer(inArr[0].hashCode());
				Integer v2 = new Integer(iList.get(j).hashCode());
				repeated=v1.equals(v2);
				if(repeated==true){
					break;
				}
			}
			if(repeated==false){
				try{
					if(Double.parseDouble(inArr[3])>Double.parseDouble(inArr[2])){
						try{
							if(inArr[4].contains("E") || inArr[4].equals("N")){
								try{
									if(inArr[4].contains("E"))
									{
										double maxAllowedPrice=(Double.parseDouble(inArr[2])/100)*25;
										if(Double.parseDouble(inArr[3])<=Double.parseDouble(inArr[2])+maxAllowedPrice){									
											a[i]=new Item(Integer.parseInt(inArr[0]),inArr[1],Double.parseDouble(inArr[2]),Double.parseDouble(inArr[3]),inArr[4]);
											iList.add(a[i]);
										}
										else{
											throw new EssentialCommodityException("E graded sales price in id "+inArr[0]+" cannot be more then 25% of purchase price");
										}
									}
									else{
										a[i]=new Item(Integer.parseInt(inArr[0]),inArr[1],Double.parseDouble(inArr[2]),Double.parseDouble(inArr[3]),inArr[4]);
										iList.add(a[i]);
									}
								}
								catch(EssentialCommodityException e){
									System.out.println("Error "+e.getMessage());
									System.exit(0);
								}
							}
							else{
								throw new GradeMismatchException("Grade from id "+inArr[0]+" is not valid");
							}
						}
						catch(GradeMismatchException e){
							System.out.println("Error "+e.getMessage());
							System.exit(0);
						}
					}
					else{
						throw new PriceException("Sales price of id "+inArr[0]+" must be higher than purchase price");
					}
				}
				catch(PriceException e){
					System.out.println("Error "+e.getMessage());
					System.exit(0);
				}
			}
			else
			{
				continue;
			}
		}
		Set<Item> hSet=new HashSet<Item>();
		for(Item x:iList){
			hSet.add(x);
		}
		return hSet;
	}
}
