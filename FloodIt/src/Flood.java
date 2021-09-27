// Imports for the parameters of flood
import java.util.*;

public class Flood {
    //O(n^3)
    public static void flood1(WaterColor color, LinkedList<Coord> flooded_list, Tile[][] tiles, Integer board_size)
    {
	// TODO
        //loop through the flooded_list and generate coordinates of the neighboring cells
        //if the cells are the same as color inputted (check through tiles and use getColor()), add them to flooded_list
        //loop through the list of flooded_coords and get the neighboring coords
        //if the neighbor coords are the same color, add it to the linked list
        WaterColor originalColor= tiles[0][0].getColor();
        List<Coord> neighbors = new ArrayList<>();
        Coord coord= new Coord(0,0);
        for(int i=0; i!=flooded_list.size(); ++i) { //O(n)
            coord= flooded_list.get(i); //O(n)
            neighbors = coord.neighbors(board_size);
            for (Coord neighborCoord : neighbors) { //constant time
                if(tiles[neighborCoord.getY()][neighborCoord.getX()].getColor() == originalColor && flooded_list.contains(neighborCoord)==false) { //.contains() is O(n)
                    flooded_list.add(neighborCoord); //O(1)
                }
            }
        }
    }

    public static void flood2(WaterColor color, LinkedList<Coord> flooded_list, Tile[][] tiles, Integer board_size)
    {
	// TODO
        ArrayList<Coord> coordList = new ArrayList<Coord>(flooded_list); //O(n)
        WaterColor originalColor= tiles[0][0].getColor();
        List<Coord> neighbors = new ArrayList<>();
        Coord coord= new Coord(0,0);

        //int size=flooded_list.size();
//        for(Coord x: coordArray){
//            System.out.println(x);
//        }
        for(int i=0; i!=coordList.size(); ++i) { //O(n)
            coord = coordList.get(i); //O(1)
            //System.out.println(coord);
            neighbors = coord.neighbors(board_size);
            for (Coord neighborCoord : neighbors) {
                //check to make sure the coord is not already in the linked list
                if(flooded_list.contains(neighborCoord)==false && tiles[neighborCoord.getY()][neighborCoord.getX()].getColor() == originalColor) { //.contains is O(n)
                    //&& hashset.contains(neighborCoord)==false
                    flooded_list.add(neighborCoord);  //O(1)
                    coordList.add(neighborCoord); //O(1) but worst case O(n)
                }
            }
        }
    }

    //O(n)
    public static void flood(WaterColor color, LinkedList<Coord> flooded_list, Tile[][] tiles, Integer board_size){
        HashSet<Coord> hashset = new HashSet<>(flooded_list);
        ArrayList<Coord> coordList = new ArrayList<Coord>(flooded_list);
        WaterColor originalColor= tiles[0][0].getColor();
        List<Coord> neighbors = new ArrayList<>();
        Coord coord= new Coord(0,0);
        for(int i=0; i!=flooded_list.size(); ++i) { //O(n)
            coord = coordList.get(i); //O(1)
            neighbors = coord.neighbors(board_size);
            for (Coord neighborCoord : neighbors) {
                if(!hashset.contains(neighborCoord) && tiles[neighborCoord.getY()][neighborCoord.getX()].getColor() == originalColor) { //.contains for hashset is O(1)
                    //&& hashset.contains(neighborCoord)==false
                    flooded_list.add(neighborCoord);  //O(1)
                    hashset.add(neighborCoord); //O(1)
                    coordList.add(neighborCoord); //O(1) but worst case O(n)
                }
            }
        }





        //HashSet<Coord> hashset = new HashSet<Coord>(flooded_list);
//        List<Coord> array = new ArrayList<Coord>(flooded_list);
//        HashSet<Coord> visited = new HashSet<Coord>();
//        List<Coord> neighbors = new ArrayList<>();
//        WaterColor originalColor= tiles[0][0].getColor();
//
//        for(int i =0; i<flooded_list.size(); ++i){
//            Coord current = array.get(i);
//
//        }
//
//        Coord current = flooded_list.getFirst();
        //neighbors = current.neighbors(board_size);




        /*HashSet<Coord> visited = new HashSet<Coord>();
        Queue<Coord> queue = new LinkedList<Coord>();
        WaterColor originalColor= tiles[0][0].getColor();
        List<Coord> neighbors = new ArrayList<>();
        queue.add(flooded_list.getLast());

        while(!queue.isEmpty()){
            Coord current = queue.remove();
            neighbors = current.neighbors(board_size);
            flooded_list.add(current);
            for(Coord neighborCoord:neighbors){
                if(!visited.contains(neighborCoord) && tiles[neighborCoord.getY()][neighborCoord.getX()].getColor()==originalColor){
                    queue.add(neighborCoord);
                    visited.add(neighborCoord);
                }
            }
            visited.add(current);
        }
        */
        //ArrayList<Coord> coordList = new ArrayList<Coord>(flooded_list);
        /*HashSet<Coord> hashset = new HashSet<Coord>(flooded_list);
        WaterColor originalColor= tiles[0][0].getColor();
        List<Coord> neighbors = new ArrayList<>();
        Coord coord= new Coord(0,0);
        HashSet<Coord> seenCoords = new HashSet<Coord>();*/


        //seenCoords.add(new Coord(0,0));
        //for(Iterator<Coord> iterator= hashset.iterator(); iterator.hasNext(); ){
        /*for(int i=0; i<flooded_list.size(); ++i) {
            coord = hashset.iterator().next();
            neighbors = coord.neighbors(board_size);
            //seenCoords.add(coord);
            for (Coord neighborCoord : neighbors) {
                //check to make sure the coord is not already in the linked list
                //if(seenCoords.contains(neighborCoord)){
                //  break;
                //}
                if (tiles[neighborCoord.getY()][neighborCoord.getX()].getColor() == originalColor && seenCoords.contains(neighborCoord)) {
                    //&& hashset.contains(neighborCoord)==false
                    flooded_list.add(neighborCoord);
                    seenCoords.add(neighborCoord);
                }
            }
        }
       // }*/

        /*while(iterator.hasNext()){
            Coord coord = iterator.next();
            neighbors = coord.neighbors(board_size);
            for (Coord neighborCoord : neighbors) {
                //check to make sure the coord is not already in the linked list
                if (tiles[neighborCoord.getY()][neighborCoord.getX()].getColor() == originalColor) {
                    //&& hashset.contains(neighborCoord)==false
                    flooded_list.add(neighborCoord);
                    //hashset.add(neighborCoord);
                }
            }
        }*/
        //}


    }

}
