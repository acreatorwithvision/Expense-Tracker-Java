#!/bin/bash

# Define colors for output
GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo -e "${GREEN}Compiling Expense Tracker...${NC}"
javac -d . src/com/expensetracker/*.java

if [ $? -eq 0 ]; then
    echo -e "${GREEN}Running Application...${NC}"
    java com.expensetracker.ExpenseTrackerApp
else
    echo "Compilation failed."
fi