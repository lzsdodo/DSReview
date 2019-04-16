package Map;

public class HashTable {

    // get(), put(), remove(), size(), isEmpty(), ...
    // I prefer to see the source code for now

    int hash(Object key) {
        int h = key.hashCode();
        // capitity means hash table's size here
        return (h ^ (h >>> 16)) & (capitity -1);
    }


    // String's hashCode in Java
    /*
    public int hashCode() {
        int var1 = this.hash;
        if(var1 == 0 && this.value.length > 0) {
            char[] var2 = this.value;
            for(int var3 = 0; var3 < this.value.length; ++var3) {
                var1 = 31 * var1 + var2[var3];
            }
            this.hash = var1;
        }
        return var1;
    }
    */

}
