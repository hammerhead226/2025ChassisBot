// Copyright 2021-2025 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import static edu.wpi.first.units.Units.Degree;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.wpilibj.RobotBase;

/**
 * This class defines the runtime mode used by AdvantageKit. The mode is always "real" when running
 * on a roboRIO. Change the value of "simMode" to switch between "sim" (physics sim) and "replay"
 * (log replay from a file).
 */
public final class Constants {
  public static final Mode simMode = Mode.SIM;
  public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public static final class FieldConstants {
    // sourced from the PhotonVision web client's default settings for tag poses

    // to get the pose of the tag ID N, simply call TAG_POSES[N]
    public static final Pose3d[] TAG_POSES = {
      null, // there does not exist a tag 0
      new Pose3d(
          16.70, 0.66, 1.49, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(126))), // tag 1
      new Pose3d(
          16.70, 7.40, 1.49, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(-126))), // tag 2
      new Pose3d(
          11.56, 8.06, 1.30, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(-90))), // tag 3
      new Pose3d(
          9.28, 6.14, 1.87, new Rotation3d(Degree.of(0), Degree.of(30), Degree.of(0))), // tag 4
      new Pose3d(
          9.28, 1.91, 1.87, new Rotation3d(Degree.of(0), Degree.of(30), Degree.of(0))), // tag 5
      new Pose3d(
          13.47, 3.31, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(-60))), // tag 6
      new Pose3d(
          13.89, 4.03, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(0))), // tag 7
      new Pose3d(
          13.47, 4.75, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(60))), // tag 8
      new Pose3d(
          12.64, 4.75, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(120))), // tag 9
      new Pose3d(
          12.23, 4.03, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(180))), // tag 10
      new Pose3d(
          12.64, 3.31, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(-120))), // tag 11
      new Pose3d(
          0.85, 0.66, 1.49, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(54))), // tag 12
      new Pose3d(
          0.85, 7.40, 1.49, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(-54))), // tag 13
      new Pose3d(
          8.27, 6.14, 1.87, new Rotation3d(Degree.of(0), Degree.of(30), Degree.of(180))), // tag 14
      new Pose3d(
          8.27, 1.91, 1.87, new Rotation3d(Degree.of(0), Degree.of(30), Degree.of(180))), // tag 15
      new Pose3d(
          5.99, -0.00, 1.30, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(90))), // tag 16
      new Pose3d(
          4.07, 3.31, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(-120))), // tag 17
      new Pose3d(
          3.66, 4.03, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(180))), // tag 18
      new Pose3d(
          4.07, 4.75, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(120))), // tag 19
      new Pose3d(
          4.90, 4.75, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(60))), // tag 20
      new Pose3d(
          5.32, 4.03, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(0))), // tag 21
      new Pose3d(
          4.90, 3.31, 0.31, new Rotation3d(Degree.of(0), Degree.of(0), Degree.of(-60))), // tag 22
    };
  }
}
