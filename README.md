# Transport Simulation

This is a transport simulation that models trucks of different sizes moving between different locations, picking-up and dropping off shipments. The simulation takes place on a two-dimensional map measured in miles.

# Features

The simulation is broken into hours of time, where each hour, trucks are either moving towards a destination, picking up a shipment, unloading a shipment, or waiting for an empty loading dock.

The different locations will track the situation at the loading docks and choose the next truck to load and/or unload cargo.

The simulation is configured from a file, with a central clock object ticking off the hours.

During each hour, each truck's action method will be executed through a user-created list containing all trucks.

Each location will perform any necessary actions and record required information.

At the start of the simulation, trucks, warehouses, and shipments will be randomly generated.

Each warehouse will have one to three loading docks, randomly determined, where trucks can drop-off and pick-up shipments.

Trucks come in five different types, capable of carrying one to five loads of cargo.

Trucks move at five different speeds, where the five-load truck moves one mile per hour and so on.

Shipments are randomly determined in sizes of one, two, or three units and cannot exceed the load size of the truck.

Deliveries are performed in a Last-in First-out fashion.
The order of pickups is based on warehouse distance from the truck's current position and the order of shipment creation.

The simulation is finished when the last truck has made its last delivery.

The simulation runs with four different configurations and ten different random seeds.

When a truck reaches a warehouse, it must wait for a loading dock to become empty and access loading docks in the order of arrival.

A dynamic map is created showing warehouse and truck locations.

The program writes to a data file on truck, shipment, and warehouse activity during the simulation in CSV format for easy graphing.

Unit tests are performed on as many classes as possible, and all classes are commented.
