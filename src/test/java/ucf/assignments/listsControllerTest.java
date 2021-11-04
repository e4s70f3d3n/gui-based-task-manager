/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Easton Vitulli
 */

package ucf.assignments;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class listsControllerTest {

        @Test
        void addItems() {
            /*
            set the expected scene.
            get actual scene.
            assert the expected and actual scenes as equal to each other.
             */
        }

        @Test
        void addList() {
            /*
            test a string value in the description text bar.
            get the actual value from the function.
            set an expected value based on input.
            assert actual and expected equals to each other.
             */
        }

        @Test
        void deleteList() {
            /*
            test an empty string value in the description text bar.
            get the actual value from the function.
            assert actual and expected equals to each other.
             */

        }

        @Test
        public void fileSaver() {
               /*
               create a new temporary output folder
               declare new FileWriter inside a new BufferedWriter inside a new PrintWriter
               to write to the new temporary output path.
               assert that the output has content ("test has content") and has parent path.
                */
        }

        @Test
        public void fileLoader() {
                 /*
                use parameterized test to get data from csv file
                copy and past pathway into test so test can pull the data straight from the file to compare.
                initialize expected values for item description and due date.
                obtain actual values for item description and due date.
                assertArrayEquals if values are true
                 */
        }
    }