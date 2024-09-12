#include <iostream>
#include <fstream>
#include <vector>
#include <unordered_map>
#include <sstream>

using namespace std;

int main() {
    const string inputFileName = "randomok.txt";
    const string outputFileName = "output.txt";
    
    ifstream inputFile(inputFileName);
    ofstream outputFile(outputFileName);
    
    if (!inputFile.is_open() || !outputFile.is_open()) {
        cerr << "Error opening files!" << endl;
        return 1;
    }
    
    vector<vector<int>> matrix;
    string line;
    
    // Read the input file
    while (getline(inputFile, line)) {
        vector<int> row;
        istringstream iss(line);
        int number;
        while (iss >> number) {
            row.push_back(number);
        }
        matrix.push_back(row);
    }
    
    unordered_map<int, vector<pair<int, int>>> positions;
    
    // Track the positions of each number
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = 0; j < matrix[i].size(); ++j) {
            int num = matrix[i][j];
            positions[num].emplace_back(i, j);
        }
    }
    
    // Replace duplicates with -1
    for (const auto& entry : positions) {
        if (entry.second.size() > 1) {
            for (const auto& pos : entry.second) {
                matrix[pos.first][pos.second] = -1;
            }
        }
    }
    
    // Write the output file
    for (const auto& row : matrix) {
        for (int num : row) {
            outputFile << num << " ";
        }
        outputFile << endl;
    }
    
    inputFile.close();
    outputFile.close();
    
    return 0;
}
