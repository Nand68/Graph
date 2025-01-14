// Direction vectors for 4-sided traversal (Up, Down, Left, Right)
int[] drow = {-1, 0, 1, 0}; // Row direction
int[] dcol = {0, 1, 0, -1}; // Column direction

// Traversing all 4 directions from a given cell
for (int d = 0; d < 4; d++) {
    int nrow = row + drow[d]; // Calculate new row
    int ncol = col + dcol[d]; // Calculate new column

    // Check boundaries or any additional conditions
    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
        // Perform necessary operations for the neighboring cell
        System.out.println("Visited cell: (" + nrow + ", " + ncol + ")");
    }
}



// Direction vectors for 8-sided traversal
int[] drow = {-1, -1, -1, 0, 1, 1, 1, 0}; // Row direction
int[] dcol = {-1,  0,  1, 1, 1, 0, -1, -1}; // Column direction

// Traversing all 8 directions from a given cell
for (int d = 0; d < 8; d++) {
    int nrow = row + drow[d]; // Calculate new row
    int ncol = col + dcol[d]; // Calculate new column

    // Check boundaries or any additional conditions
    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
        // Perform necessary operations for the neighboring cell
        System.out.println("Visited cell: (" + nrow + ", " + ncol + ")");
    }
}
