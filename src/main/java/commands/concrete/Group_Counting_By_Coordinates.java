package commands.concrete;

import collection.WorkerColManager;
import collection.entity.Coordinates;
import collection.entity.Worker;
import commands.Command;

import java.util.List;
import java.util.Map;

/**
 * Group counting by coordinates command. Selects elements of collection with same coordinates
 * and displays received groups.
 */
public class Group_Counting_By_Coordinates extends Command {
    /**
     * Collection manager to work with.
     */
    private final WorkerColManager colManager;

    /**
     * Initialised collection manager, the name and the description of the new command.
     */
    public Group_Counting_By_Coordinates(WorkerColManager colManager) {
        super("group_counting_by_coordinates",
                "group the elements of the collection by the value of the field coordinates," +
                        " display the number of elements in each group");
        this.colManager = colManager;
    }

    /**
     * Groups workers from collection into groups and writes them down in a lists as a values in Map,
     * keys to which are coordinates of workers in appropriating list.
     *
     * @param args an empty string as an imperfection of the program model
     */
    @Override
    public void action(String args) {
        Map<Coordinates, List<Worker>> map = colManager.getGroupsByCoordinates();
        for (Map.Entry<Coordinates, List<Worker>> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue().toString());
        }
    }
}
