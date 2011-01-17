/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.controller.registry;

import org.jboss.as.controller.OperationHandler;

/**
 * Information about handling an attribute in a sub-model.
 *
 * @author Brian Stansberry
 */
public class AttributeAccess {

    public static enum AccessType {
        READ_ONLY,
        WRITE_ONLY,
        READ_WRITE
    }

    private final AccessType access;
    private final OperationHandler readHandler;
    private final OperationHandler writeHandler;

    public AttributeAccess(final AccessType access, final OperationHandler readHandler, final OperationHandler writeHandler) {
        assert access != null : "access is null";
        this.access = access;
        this.readHandler = readHandler;
        this.writeHandler = writeHandler;
        if (access != AccessType.READ_ONLY && writeHandler == null) {
            throw new IllegalArgumentException("writeHandler is null");
        }
    }

    public AccessType getAccessType() {
        return access;
    }

    public OperationHandler getReadHandler() {
        return readHandler;
    }

    public OperationHandler getWriteHandler() {
        return writeHandler;
    }
}
