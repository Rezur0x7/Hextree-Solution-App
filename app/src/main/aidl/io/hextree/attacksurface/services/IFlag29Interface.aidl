// IFlag29Interface.aidl
package io.hextree.attacksurface.services;

interface IFlag29Interface {
    String init();
    void authenticate(in String password);
    void success();
}