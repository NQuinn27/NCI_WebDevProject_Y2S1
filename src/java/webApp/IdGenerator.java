/*
 * Copyright 2014 niallquinn
 * IdGenerator.java created Nov 29, 2014
 * WebDevProject
 */
package webApp;

import java.io.Serializable;

/**
 *
 * @author niallquinn
 */
public class IdGenerator implements Serializable {
        private static IdGenerator instance = new IdGenerator();
        private int nextId;

        private IdGenerator () {
        }

        public static int nextId() {
            return instance.nextId++;
        }

        // readResolve method to preserve singleton property
        private Object readResolve() {
            return instance;
        }
    }
