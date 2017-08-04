package com.QATestLab;

/**
 * Created by Anton on 04.08.2017.
 */
public enum Race {
    PEOPLE {
        @Override
        public String toString() {
            return "People";
        }
    },
    ORC {
        @Override
        public String toString() {
            return "Orc";
        }
    },
    UNDEAD {
        @Override
        public String toString() {
            return "Undead";
        }
    },
    ELF {
        @Override
        public String toString() {
            return "Elf";
        }
    }
}
