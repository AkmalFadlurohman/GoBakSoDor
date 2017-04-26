package movable;

/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */

/**
 * Movable.
 * Menentukan apakan objek dapat bergerak atau tidak
 */
public interface Movable {
  /**
   * Memindahkan posisi objek berdasarkan code.
   * @param code Kode arah gerak
   */
  void move(int code);
}
