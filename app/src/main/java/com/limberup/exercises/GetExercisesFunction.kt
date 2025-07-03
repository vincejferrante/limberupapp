package com.limberup.exercises



fun getExercises(): List<Exercise> {
    return listOf(
        Exercise(
            name = "Ab Upper Slide",
            displayResId = R.drawable.ab_upper_slide,
            description = "Lie flat on the floor with your knees bent. Raise your head and shoulders slightly while extending your arms forward, parallel to the floor. Curl your back up until your hands reach beyond your shins, then lower your torso while keeping your arms and shoulders raised. Repeat the motion multiple times.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),
        Exercise(
            name = "Abdominal Crunch",
            displayResId = R.drawable.abdominal_crunch,
            description = "Lie flat on the floor with both knees bent. Raise your head and shoulders slightly from the ground. Place both palms under the back of your head with your elbows extended out to the sides.  Raise your back up from the ground toward your knees. Lower your torso back down, keeping your head and shoulders raised. ",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),
        Exercise(
            name = "Hand Clasp Ab Lift",
            displayResId = R.drawable.abdominal_lift_hand_clasp,
            description = "Lie on your back with your knees bent and feet flat on the floor. Extend your arms straight up toward the ceiling, clasping your hands together. Engage your core as you lift your shoulders off the floor and twist your torso to the right. Return to the starting position, then repeat the movement to the left. Continue alternating sides in a smooth, controlled motion.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),
        Exercise(
            name = "Abdominal Lift Legs Up",
            displayResId = R.drawable.abdominal_lift_legs_up,
            description = "Lie flat on your back with both legs extended straight up and your hands placed beneath your head. Engage your core to lift your head and shoulders off the ground into an abdominal crunch, keeping your legs straight and steady. Hold the position for five seconds or more, then slowly lower your shoulders back to the floor.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),
        Exercise(
            name = "Abdominal Lift Pose 1",
            displayResId = R.drawable.abdominal_lift_pose_1,
            description = "Lie flat on your back with your hands behind your head. Extend your left leg straight up while keeping your right leg on the floor with toes pointed. Lift your arms and shoulders off the ground and hold the position for thirty seconds or more before lowering and switching sides.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),
        Exercise(
            name = "Bent Knee Ab Lift",
            displayResId = R.drawable.abdominal_lift_shoulder_raise_knees_bent,
            description = "Lie flat on your back with knees bent and arms at your sides. Lift your shoulders off the ground, hold for five seconds or more, then slowly lower back down.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Hip Flexors")
        ),
        Exercise(
            name = "Elbow Reach Ab Lift",
            displayResId = R.drawable.abdominal_lift_twist_elbows_extended,
            description = "Lie on your back with elbows extended to the sides. Engage your core, lift your shoulders, and twist your torso to bring one elbow toward the opposite knee. Return and repeat on the other side.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Abdominals"),
        ),
        Exercise(
            name = "Clasped Hands Ab Lift Twist",
            displayResId = R.drawable.abdominal_lift_twist_elbows_extended,
            description = "Lie on your back, with knees bent, and extend your arms above your shoulders, claspe hands together. Raise your shoulders off the floor and twist your torso to bring one elbow toward the opposite knee. Return and repeat on the other side. twisting your torso to each side. Repeat or hold on on side and move to another",
            duration = 30,
            muscleGroups = listOf("Obliques", "Abdominals"),
        ),
        Exercise(
            name = "Two-Leg Ab Lift",
            displayResId = R.drawable.abdominal_lift_two_legs_extended,
            description = "Lie on your back with arms at your sides. Slowly raise your legs and upper body off the floor, keeping your legs straight and core engaged.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Hip Flexors")
        ),
        Exercise(
            name = "Twist Ab Lift & Leg Reach",
            displayResId = R.drawable.abdominal_lift_with_twist_and_leg_stretch,
            description = "Lie on your back with knees bent and arms extended. Raise one leg and lift your shoulders, twisting your torso toward the raised leg. Alternate sides in a controlled motion.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Obliques", "Hip Flexors")
        ),
        Exercise(
            name = "Ballet Bar Abduction Stretch",
            displayResId = R.drawable.abduction_stretch_leg_corssed_under_ballet_bar,
            description = "Stand next to a ballet bar. Cross one leg behind you and lean toward the bar while reaching overhead. Hold the stretch, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Hip Abductors", "Obliques")
        ),
        Exercise(
            name = "Abductor Stretch Hip Out",
            displayResId = R.drawable.abductor_stretch_hip_out,
            description = "Stand beside a chair. Lean your torso sideways toward it without rounding your back. Reach to hold the chair and stretch your outer hip. Alternate sides.",
            duration = 20,
            muscleGroups = listOf("Hip Abductors")
        ),
        Exercise(
            name = "Abductor Stretch Leg Crossed Under",
            displayResId = R.drawable.abductor_stretch_leg_crossed_under,
            description = "Stand facing a chair. Cross one leg behind the other, keeping feet forward. Lean your torso toward the front leg for a deep hip stretch. Switch sides.",
            duration = 20,
            muscleGroups = listOf("Hip Abductors")
        ),
        Exercise(
            name = "Achilles Stretch Crouching",
            displayResId = R.drawable.achilles_stretch_crouching,
            description = "Start on all fours. Bring one knee forward and extend the opposite leg behind you. Press the back heel toward the floor to stretch the Achilles.",
            duration = 20,
            muscleGroups = listOf("Calves", "Ankles")
        ),
        Exercise(
            name = "Down Dog Heel Stretch",
            displayResId = R.drawable.achilles_stretch_downward_dog,
            description = "From downward dog, keep one heel flat while lifting the opposite heel. Bend the raised leg slightly to deepen the stretch. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Calves", "Hamstrings")
        ),
        Exercise(
            name = "Achilles To Side",
            displayResId = R.drawable.achilles_stretch_to_side,
            description = "Sit with one leg extended to the side and the other tucked in. Lean toward the extended leg, reaching your foot while rotating your chest open. Switch sides.",
            duration = 20,
            muscleGroups = listOf("Calves", "Obliques", "Shoulders")
        ),
        Exercise(
            name = "Wall Achilles Stretch 2",
            displayResId = R.drawable.achilles_stretch_wall_supported_2,
            description = "Stand a few inches from a wall. Shift your weight to one foot and extend the other leg behind you. Lean into the wall and hold. Switch sides.",
            duration = 20,
            muscleGroups = listOf("Calves", "Ankles")
        ),
        Exercise(
            name = "Adductor Stretch Side Squat",
            displayResId = R.drawable.adductor_stretch_side_squat,
            description = "Stand with your knees slightly bent. Extend one leg out to the side and place your hand on the floor for support if needed. Lean into the bent leg while keeping the extended leg straight. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Inner Thighs")
        ),
        Exercise(
            name = "Beginner Side Squat Stretch",
            displayResId = R.drawable.adductor_stretch_side_squat_easy,
            description = "Stand with feet apart and shift into a side lunge by extending one leg. Rest your hands on the bent knee and gently press your hips downward. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Hips")
        ),
        Exercise(
            name = "Adductor Wide Squat",
            displayResId = R.drawable.adductor_stretch_wide_squat,
            description = "Stand with legs wide apart and hands resting on your knees. Lower your pelvis as far as comfortable to deepen the inner thigh stretch. Hold the position while keeping your chest upright.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Glutes", "Hips")
        ),
        Exercise(
            name = "Angle Pose",
            displayResId = R.drawable.angle_pose,
            description = "Sit cross-legged on the floor. Reach one arm behind your back to hold the opposite waist. Place the other hand beside you on the floor and gently twist, opening the shoulder and chest.",
            duration = 20,
            muscleGroups = listOf("Shoulders", "Spine", "Chest")
        ),
        Exercise(
            name = "Angle Pose Bound 2",
            displayResId = R.drawable.angle_pose_bound_2,
            description = "Sit cross-legged and reach both arms behind your back, clasping opposite elbows. Gently pull your elbows downward to open the chest and deepen the shoulder stretch.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Chest")
        ),
        Exercise(
            name = "Angle Pose Equilibrium",
            displayResId = R.drawable.angle_pose_equilbrium,
            description = "Sit on the floor with knees bent and soles of the feet pressed together. Reach forward to grab your feet, lift them off the ground, and hold the position for balance and hip mobility.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Hips", "Core")
        ),
        Exercise(
            name = "Ankle Circles",
            displayResId = R.drawable.ankle_circles,
            description = "Sit or lie down with legs extended. Slowly rotate your ankles in circular motions, first clockwise, then counterclockwise. Focus on full, controlled movement.",
            duration = 30,
            muscleGroups = listOf("Ankles", "Calves")
        ),
        Exercise(
            name = "Ankle Flexion Wall Supported",
            displayResId = R.drawable.ankle_flexion_wall_supported,
            description = "Stand facing a wall and press your palms against it at shoulder height. Bring one foot forward and press the toes into the wall while keeping the back heel grounded. Lean forward gently for a deep stretch. Switch sides.",
            duration = 30,
            muscleGroups = listOf("Ankles", "Calves")
        ),
        Exercise(
            name = "Ankle on Knee Stretch",
            displayResId = R.drawable.ankle_on_knee_stretch,
            description = "Sit upright and cross one ankle over the opposite knee. Lean forward gently to deepen the hip and glute stretch. Keep your spine long and switch sides after holding.",
            duration = 30,
            muscleGroups = listOf("Glutes", "Hips")
        ),
        Exercise(
            name = "Ankle Up and Downs",
            displayResId = R.drawable.ankle_up_and_downs,
            description = "While seated or lying down, flex and point your toes repeatedly. Move through a full range of motion to warm up the ankles and improve mobility.",
            duration = 30,
            muscleGroups = listOf("Ankles", "Calves")
        ),
        Exercise(
            name = "Anterior & Lateral Leg Stretch",
            displayResId = R.drawable.anterior_and_lateral_lower_leg_forward_bend,
            description = "Sit with legs folded in front of you and slowly lean forward, reaching toward your feet. Focus on stretching the front and outer sides of the lower legs.",
            duration = 30,
            muscleGroups = listOf("Shins", "Calves", "Ankles")
        ),
        Exercise(
            name = "Anterior Foot Stretch",
            displayResId = R.drawable.anterior_foot_stretch,
            description = "Kneel with the tops of your feet flat against the floor. Gently sit back onto your heels to stretch the front of the ankles and tops of the feet. Hold while maintaining an upright spine.",
            duration = 30,
            muscleGroups = listOf("Feet", "Ankles")
        ),
        Exercise(
            name = "Archer Pose Prep",
            displayResId = R.drawable.archer_pose_prep,
            description = "Begin seated with your legs extended. Place your left hand flat on the floor in front of your left knee and bend your left keen. HOld your left foot with your right hand and lift your left leg from the floor.",
            duration = 30,
            muscleGroups = listOf("Abductors")
        ),
        Exercise(
            name = "Arm Circles",
            displayResId = R.drawable.arm_circles,
            description = "Stand tall with arms extended out to the sides. Make small, controlled circles going forward, then reverse the direction. Keep your shoulders down and relaxed.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Arms", "Upper Back")
        ),
        Exercise(
            name = "Bent Knee Arm Extension",
            displayResId = R.drawable.arm_extension_with_bent_knees,
            description = "Lie on your back with knees bent and feet flat. Extend your arms overhead and stretch long through the fingertips. Focus on elongating the spine and opening the shoulders.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Latissimus dorsi")
        ),
        Exercise(
            name = "Side Arm Band Stretch",
            displayResId = R.drawable.arm_lengthener_to_side_with_band,
            description = "Stand or kneel with a resistance band held in both hands. Extend one arm overhead and lean to the opposite side, keeping tension in the band to stretch the side body and shoulder.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Lats", "Obliques")
        ),
        Exercise(
            name = "Arms Above Head Toe Flex",
            displayResId = R.drawable.arms_above_head_toe_flex,
            description = "Lie flat on your back with arms and legs extended. Point your toes and stretch your body by reaching through your fingertips and feet, creating length from end to end.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Spine", "Calves")
        ),
        Exercise(
            name = "One-Leg Tiptoe Baby Cradle",
            displayResId = R.drawable.baby_cradle_pose_in_one_legged_tiptoe,
            description = "Begin in a low crouch on your tiptoes. Cross one foot over the opposite thigh and use your hands to gently draw the leg toward your chest. Hold the pose while maintaining balance, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Hips", "Glutes", "Ankles")
        ),
        Exercise(
            name = "Back Extension Prone",
            displayResId = R.drawable.back_extension_prone,
            description = "Kneel in front of a stability ball with arms extended overhead. Rest your hands on the ball and gently tilt your torso to one side to stretch through the back and shoulders.",
            duration = 30,
            muscleGroups = listOf("Back", "Shoulders", "Lats")
        ),
        Exercise(
            name = "Back Rolls",
            displayResId = R.drawable.back_rolls,
            description = "Lie on your back and hug your knees to your chest. Gently rock along the spine from shoulders to tailbone in a smooth, massaging motion.",
            duration = 30,
            muscleGroups = listOf("Spine", "Lower Back", "Core")
        ),
        Exercise(
            name = "Back Rotation Standing",
            displayResId = R.drawable.back_rotation_standing,
            description = "Stand tall with arms crossed over your chest. Gently rotate your torso side to side while keeping your hips stable and your core engaged.",
            duration = 30,
            muscleGroups = listOf("Spine", "Obliques")
        ),
        Exercise(
            name = "Bent Over Wide-Leg Stretch",
            displayResId = R.drawable.back_stretch_bent_over_sitting_legs_spread,
            description = "Sit with your legs extended wide apart. Reach your hands forward between your knees and round your back, letting your head drop toward your chest. Relax into the stretch.",
            duration = 30,
            muscleGroups = listOf("Lower Back", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Back Stretch Reaching",
            displayResId = R.drawable.back_stretch_reaching,
            description = "Stand tall with arms extended overhead. Cross your wrists and actively reach toward the ceiling, feeling the stretch through your spine and shoulders.",
            duration = 30,
            muscleGroups = listOf("Back", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Back Stretch with Reach",
            displayResId = R.drawable.back_stretch_with_arms_reaching_1,
            description = "Begin in a kneeling position and reach your arms forward on the floor. Lower your hips to your heels and allow your head to rest down, stretching through the spine and shoulders.",
            duration = 15,
            muscleGroups = listOf("Back", "Shoulders", "Hips")
        ),
        Exercise(
            name = "Back Twist Upward",
            displayResId = R.drawable.back_twist_upward,
            description = "Crouch low with one knee grounded. Twist your torso and place your opposite hand on your hip, reaching your other arm behind you. Lift your gaze to open the chest and deepen the spinal twist.",
            duration = 15,
            muscleGroups = listOf("Spine", "Obliques", "Shoulders")
        ),
        Exercise(
            name = "Behind Clasp Backbend",
            displayResId = R.drawable.backbend_arms_clasped_behind,
            description = "Stand upright and clasp your hands behind your back. Open your chest and gently arch backward, reaching your arms down to deepen the stretch through the front body.",
            duration = 15,
            muscleGroups = listOf("Chest", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Bicep Self Stretch",
            displayResId = R.drawable.bicep_self_stretch,
            description = "Kneel on the floor with a chair or stable surface behind you. Reach one arm back to grab the top of the chair and gently lean your body forward to stretch the bicep and shoulder.",
            duration = 30,
            muscleGroups = listOf("Biceps", "Shoulders", "Chest")
        ),
        Exercise(
            name = "Seated Forward Bend",
            displayResId = R.drawable.bilateral_seated_forward_bend,
            description = "Sit with your legs extended straight in front of you. Slowly fold forward, lowering your head and shoulders toward your knees while keeping your spine long. Relax into the stretch.",
            duration = 15,
            muscleGroups = listOf("Hamstrings", "Lower Back", "Spine")
        ),
        Exercise(
            name = "Supported Boat Twist",
            displayResId = R.drawable.boat_pose_revolved_supported,
            description = "Begin seated with your hands on the floor behind you. Cross one foot over the other and lift both legs. Hold one foot with the opposite hand while twisting your torso toward the rear arm. Extend the spine and maintain balance.",
            duration = 30,
            muscleGroups = listOf("Core", "Obliques", "Hip Flexors")
        ),
        Exercise(
            name = "Half Standing Intense Stretch",
            displayResId = R.drawable.both_hands_to_foot_half_standing_wind_relieving_intense_stretch_pose,
            description = "Stand upright and bend one leg behind you so the foot touches your hip. Hold the foot with both hands and lean forward into a deep stretch. Maintain balance before switching sides.",
            duration = 15,
            muscleGroups = listOf("Lower back", "Hamstrings", "Balance")
        ),
        Exercise(
            name = "Bound Ankle Chest Opener",
            displayResId = R.drawable.bound_ankle_chest_opener,
            description = "Kneel upright with knees hip-width apart and feet flat. Place your hands on your lower back with fingers pointing down. Lean your chest and shoulders back, reaching for your ankles to deepen the stretch.",
            duration = 30,
            muscleGroups = listOf("Chest")
        ),
        Exercise(
            name = "Bound Ankle Chest Opener",
            displayResId = R.drawable.bound_ankle_chest_opener_intense_wrist,
            description = "Kneel with knees hip-width apart and hands on your lower back. Lean your torso back and place your palms on the floor behind you with fingers pointing forward, deepening the stretch through the chest and wrists.",
            duration = 30,
            muscleGroups = listOf("Wrists", "Hip Flexors")
        ),
        Exercise(
            name = "Bound Arm Stretch Behind",
            displayResId = R.drawable.bound_arm_stretch_behind,
            description = "Sit cross-legged and clasp your hands behind your back. Straighten your arms and gently lift them away from your body to open the chest and stretch the shoulders.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Bound Revolved Back Stretch",
            displayResId = R.drawable.bound_revolved_half_intense_back_stretch_pose,
            description = "Stand with feet hip-width apart and fold forward at the waist. Thread one arm through the legs and wrap the other arm behind your back to bind the hands together. Deepen the twist by rotating the torso.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Shoulders", "Obliques", "Hamstrings")
        ),
        Exercise(
            name = "Half Bound Stretch (Uneven Legs)",
            displayResId = R.drawable.bound_revolved_half_intense_back_stretch_pose_1,
            description = "Begin in a forward fold with one foot on tiptoes. Reach one arm through the bent leg and around the back. Wrap the opposite arm behind to bind the hands. Twist your torso and hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Glutes", "Hamstrings")
        ),
        Exercise(
            name = "Bow Pose",
            displayResId = R.drawable.bow_pose,
            description = "Lie on your stomach with arms at your sides and legs extended. Bend your knees and reach back to grab your ankles. Lift your chest and thighs off the floor, drawing the shoulder blades together and opening the front body.",
            duration = 30,
            muscleGroups = listOf("Back", "Chest", "Hip Flexors", "Quads")
        ),
        Exercise(
            name = "Bridge on Forehead",
            displayResId = R.drawable.bridge_on_forehead,
            description = "Lie on your back with knees bent and hands beside your head, fingers pointing toward your shoulders. Press into your hands and feet to lift your body, allowing the top of your head to rest on the floor.",
            duration = 15,
            muscleGroups = listOf("Spine")
        ),
        Exercise(
            name = "Bridge on Forehead Modification",
            displayResId = R.drawable.bridge_on_forehead_modifican,
            description = "Start in a bridge pose with your head resting lightly on the floor. Once stable, lift your hands and cross them over your chest to deepen the stretch and challenge your stability.",
            duration = 15,
            muscleGroups = listOf("Spine")
        ),
        Exercise(
            name = "Butterfly Pose",
            displayResId = R.drawable.butterfly_knees_heels_to_groin,
            description = "Sit on the floor with the soles of your feet pressed together. Hold your feet and gently pull them toward your body, allowing your knees to relax toward the floor.",
            duration = 15,
            muscleGroups = listOf("Adductors", "Hips", "Lower Back")
        ),
        Exercise(
            name = "Butterfly Feet to Forehead",
            displayResId = R.drawable.butterfly_stretch_feet_to_forehead,
            description = "Sit in butterfly position and lift your feet off the floor while keeping heels and toes pressed together. Gently pull your feet toward your forehead to increase the stretch.",
            duration = 15,
            muscleGroups = listOf("Hips", "Adductors", "Lower Back")
        ),
        Exercise(
            name = "Camel Pose",
            displayResId = R.drawable.camel_pose,
            description = "Kneel with knees hip-width apart and feet flat. Place your hands on your lower back or reach for your ankles. Arch your spine and lift your chest, leaning back to stretch the front body.",
            duration = 15,
            muscleGroups = listOf("Chest", "Shoulders")
        ),
        Exercise(
            name = "Camel Pose Prep",
            displayResId = R.drawable.camel_pose_prep,
            description = "Start kneeling with knees hip-width apart. Place your hands on your lower back and gently lean backward, opening your chest and pressing into your hips to deepen the stretch.",
            duration = 15,
            muscleGroups = listOf("Chest")
        ),
        Exercise(
            name = "Cat Pose",
            displayResId = R.drawable.cat_pose,
            description = "Start on all fours with your hands under shoulders and knees under hips. Round your back by pulling your spine toward the ceiling, dropping your head and shoulders. Hold and breathe deeply.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Spine")
        ),
        Exercise(
            name = "Standing Cat Stretch",
            displayResId = R.drawable.cat_stretch_standing_extended_forward_bend,
            description = "Stand with feet shoulder-width apart and hands on your knees. Lean forward until your back is parallel to the floor. Arch your spine upward to stretch the upper back, then return to start.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Spine", "Hamstrings")
        ),
        Exercise(
            name = "Chair Kicks",
            displayResId = R.drawable.chair_kicks,
            description = "Stand beside a chair and shift weight to the inside leg. Swing the outer leg forward and backward without touching the floor, keeping the motion fluid and controlled.",
            duration = 30,
            muscleGroups = listOf("Glutes", "Hip Flexors", "Hamstrings")
        ),
        Exercise(
            name = "Half Bound Chair Squat Stretch",
            displayResId = R.drawable.chair_squat_intense_wrist_stretch_revolved_half_bound,
            description = "Stand tall and reach one arm behind your back to grasp the opposite hip. Lower into a deep chair squat, then twist your torso and place the opposite hand on the floor behind you. Open the chest and gaze upward.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Chair Stretch Twist",
            displayResId = R.drawable.chair_stretch_for_spine,
            description = "Lie on your back with your feet on a chair. Cross one ankle over the other and let your knees fall to one side, keeping your shoulders grounded. Hold, then switch sides.",
            duration = 15,
            muscleGroups = listOf("Spine")
        ),
        Exercise(
            name = "Band Chest Opener (Feet Anchored)",
            displayResId = R.drawable.chest_opener_side_twist_on_ball_1,
            description = "Sit tall on a fitness ball with feet wide apart. Twist your torso to one side, reaching across to hold the opposite knee. Extend your other arm upward and behind you, lifting your gaze to open the chest. Switch sides after holding.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),
        Exercise(
            name = "Ball Chest Opener (Hands Clasped)",
            displayResId = R.drawable.chest_opener_with_clasped_hands_on_ball,
            description = "Sit on an exercise ball with legs spread apart. Clasp your hands in front of you with palms outward. Lean your head back and stretch your chest by pressing the arms forward and upward.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),
        Exercise(
            name = "Chest Rotation Seated",
            displayResId = R.drawable.chest_rotation_seated,
            description = "Sit on the floor with legs extended. Cross one leg over the other and twist your torso toward the bent knee. Use the opposite arm for support to deepen the stretch and open the chest. Alternate sides.",
            duration = 20,
            muscleGroups = listOf("Chest opener")
        ),
        Exercise(
            name = "Chest Rotation Seated Variation",
            displayResId = R.drawable.chest_rotation_seated_variation,
            description = "Begin seated with one knee dropped to the floor and foot tucked under. Cross the opposite leg over and place your foot beside the knee. Use your arm to support the twist, placing your hand behind you for stability. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Chest opener")
        ),
        Exercise(
            name = "Chest to Floor Twist",
            displayResId = R.drawable.chest_to_floor_twist,
            description = "Lie on your stomach and bend both knees to one side, stacking them. Place your hands under your shoulders and gently lift one shoulder to deepen the spinal twist. Hold, then switch sides.",
            duration = 20,
            muscleGroups = listOf("Spine", "Lower Back", "Obliques")
        ),
        Exercise(
            name = "Chest to Ground",
            displayResId = R.drawable.chest_to_ground,
            description = "Start in a kneeling position and extend your arms between your knees. Rest your palms on the floor beneath your feet and gently press your chest and shoulders toward the ground.",
            duration = 20,
            muscleGroups = listOf("Chest", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Cobra",
            displayResId = R.drawable.cobra,
            description = "Lie on your stomach with hands beneath your shoulders. Press through your palms to lift your chest, straightening your arms. Pull your shoulders back and gaze upward, opening the chest and spine.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Core", "Chest")
        ),
        Exercise(
            name = "Cobra Easy Modification",
            displayResId = R.drawable.cobra_easy_modification,
            description = "Lie face-down with your hands by your shoulders. Gently lift your chest off the floor, keeping elbows tucked in. Hold the position without locking your arms.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Core")
        ),
        Exercise(
            name = "Cobra Stretch",
            displayResId = R.drawable.cobra_stretch,
            description = "Lie on your stomach and place your hands under your shoulders. Press up to lift your chest, straightening your arms while keeping your shoulders back and chest open.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Upper Back")
        ),
        Exercise(
            name = "Cobra Stretch Prep",
            displayResId = R.drawable.cobra_stretch_prep,
            description = "Lie flat on your stomach with hands under your shoulders. Gently lift your head while keeping your chin down and spine long. Hold to prepare for deeper back bends.",
            duration = 20,
            muscleGroups = listOf("Chest", "Upper Back", "Neck")
        ),
        Exercise(
            name = "Twined Legs Cobra Backbend",
            displayResId = R.drawable.cobra_twined_legs_backbend,
            description = "Lie face-down and cross one leg over the other. With hands beneath your shoulders, lift your chest and hips while pulling your shoulders back. Raise your gaze to deepen the backbend.",
            duration = 15,
            muscleGroups = listOf("Chest", "Hip Flexors", "Spine")
        ),
        Exercise(
            name = "Complete Side Leg Stretch",
            displayResId = R.drawable.complete_side_leg_stretch,
            description = "Stand tall and raise one knee into your chest. Grab your foot with the same-side hand and extend your leg straight up along your side. Once balanced, wrap your opposite arm behind your back and hold the stretch while gazing upward. Switch sides after holding.",
            duration = 10,
            muscleGroups = listOf("Adductors", "Hamstrings", "Hip Flexors", "Core")
        ),
        Exercise(
            name = "Corner Stretch",
            displayResId = R.drawable.corner_stretch,
            description = "Stand facing a corner with palms and forearms pressed against each wall, elbows just below shoulder height. Lean forward slowly until you feel a gentle stretch through the chest and front shoulders.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Chest", "Upper Back")
        ),
        Exercise(
            name = "Cow Pose 1",
            displayResId = R.drawable.cow_pose_1,
            description = "Begin on all fours with hands under shoulders and knees under hips. Drop your belly toward the floor while lifting your chest and gaze toward the ceiling, creating a deep arch through the spine.",
            duration = 15,
            muscleGroups = listOf("Spine", "Chest", "Abdominals")
        ),
        Exercise(
            name = "One-Leg Crescent Pose",
            displayResId = R.drawable.crescent_pose_one_legge,
            description = "Stand tall with arms extended overhead and palms together. Lift one leg slightly off the floor to the side while leaning your torso and arms in the opposite direction. Feel the stretch through the side body as you hold, then switch sides.",
            duration = 15,
            muscleGroups = listOf("Obliques", "Glutes", "Shoulders", "Core")
        ),
        Exercise(
            name = "Crescent Pose Standing",
            displayResId = R.drawable.crescent_pose_standing,
            description = "Stand upright with fingers clasped and arms raised overhead. Keeping your spine long and shoulders relaxed, gently bend to one side to stretch through the opposite lat and side body. Switch sides after holding.",
            duration = 15,
            muscleGroups = listOf("Latissimus Dorsi", "Obliques", "Spine")
        ),
        Exercise(
            name = "Tiptoe Eastern Stretch Pose",
            displayResId = R.drawable.eastern_intense_stretch_pose_tiptoes,
            description = "Sit with knees bent and palms flat behind you, fingers pointing backward. Lift onto your tiptoes and fingertips, then raise your hips and open your chest, letting your head fall gently back.",
            duration = 20,
            muscleGroups = listOf("Abdominals", "Chest", "Shoulders")
        ),
        Exercise(
            name = "Easy Spinal Twist",
            displayResId = R.drawable.easy_spinal_twist,
            description = "Stand with feet shoulder-width apart. Cross one arm across your torso and twist to the opposite side, reaching the back arm behind you. Turn your gaze with the twist and hold before switching sides.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Obliques")
        ),
        Exercise(
            name = "Easy Upper Back Stretch",
            displayResId = R.drawable.easy_upper_back_stretch,
            description = "Stand with feet apart and lean forward from the waist. Gently pull your shoulders downward while extending your neck forward to stretch through the upper back.",
            duration = 10,
            muscleGroups = listOf("Upper Back", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Elbow Circles",
            displayResId = R.drawable.elbow_circles,
            description = "Stand upright and place your fingertips on your shoulders. Raise your elbows to shoulder height and slowly circle them forward and backward to warm up the shoulder joints.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Upper Back")
        ),
        Exercise(
            name = "Extended Fish Pose",
            displayResId = R.drawable.extended_fish_pose,
            description = "Lie on your back and rest the crown of your head on the floor. Raise your legs to a 45-degree angle and extend your arms straight up toward the ceiling. Hold the pose while keeping the spine arched.",
            duration = 15,
            muscleGroups = listOf("Chest", "Neck", "Core")
        ),
        Exercise(
            name = "Prayer Hands Extended Fish Pose",
            displayResId = R.drawable.extended_fish_pose_with_prayer_hands,
            description = "Lie back and rest the crown of your head on the floor. Raise your crossed legs to 45 degrees and bring your hands together in prayer position beneath your arched back. Hold and breathe deeply.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Hip Flexors")
        ),
        Exercise(
            name = "Crossed Arms Extended Staff Pose",
            displayResId = R.drawable.extended_four_limbs_staff_pose_arms_crossed,
            description = "Lie face-down with arms crossed under opposite shoulders. Lift onto your toes and step feet apart. Press into your forearms to raise your body, forming a straight line from shoulders to heels.",
            duration = 20,
            muscleGroups = listOf("Chest", "Shoulders", "Core", "Triceps")
        ),
        Exercise(
            name = "Extended Staff Pose (Leg to Side) 1",
            displayResId = R.drawable.extended_four_limbs_staff_pose_leg_to_side_1,
            description = "Begin on all fours and extend one leg out to the side, keeping the foot flat on the floor. Press your hips gently toward the floor to deepen the stretch. Switch legs after holding.",
            duration = 30,
            muscleGroups = listOf("Abductors", "Hips", "Inner Thighs")
        ),
        Exercise(
            name = "Extended Staff Pose (Leg to Side) 2",
            displayResId = R.drawable.extended_four_limbs_staff_pose_leg_to_side_2,
            description = "Start on all fours and extend one leg to the side, resting on the inner edge of the foot. Straighten the supporting leg to lift the knee off the floor. Hold, then switch legs.",
            duration = 30,
            muscleGroups = listOf("Abductors", "Glutes", "Core")
        ),
        Exercise(
            name = "Extended Staff Pose (Leg to Side) 3",
            displayResId = R.drawable.extended_four_limbs_staff_pose_leg_to_side_3,
            description = "Begin in a tabletop position and extend one leg to the side. Lift the opposite knee, then raise the extended leg to hip height. Hold the pose while maintaining alignment. Alternate sides.",
            duration = 20,
            muscleGroups = listOf("Abductors", "Glutes", "Core", "Shoulders")
        ),
        Exercise(
            name = "Revolved Extended Staff Pose",
            displayResId = R.drawable.extended_four_limbs_staff_pose_revolved,
            description = "From a plank position, rotate to one side and stack your feet. Hold the side plank with control, engaging your obliques. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Obliques", "Shoulders", "Core")
        ),
        Exercise(
            name = "Extended Side Angle",
            displayResId = R.drawable.extended_side_angle_stretch,
            description = "Step into a deep side squat and lower your hand near the supporting foot. Extend your opposite arm overhead, creating a long line from fingertips to outer hip. Switch sides after holding.",
            duration = 15,
            muscleGroups = listOf("Obliques", "Hips", "Adductors", "Spine")
        ),
        Exercise(
            name = "Feet Spread Backbend",
            displayResId = R.drawable.feet_spread_backbend,
            description = "Stand with feet wide apart and hands on your lower back. Lean backward, sliding your hands down your legs and lifting your chest upward. Hold and return to standing.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Hip Flexors")
        ),
        Exercise(
            name = "Feet Spread Intense 1",
            displayResId = R.drawable.feet_spread_out_intense_stretch_pose_1,
            description = "Stand with feet wide and bend forward, placing hands between your legs. Lower your head toward the floor and reach your arms behind you, palms on the ground.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Feet Spread Intense 2",
            displayResId = R.drawable.feet_spread_out_intense_stretch_pose_2,
            description = "With feet wide apart, bend forward at the hips and let your head and shoulders hang toward the floor. Keep your hands on your lower back to emphasize the upper back stretch.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Spine", "Hamstrings")
        ),
        Exercise(
            name = "Feet Spread Intense 3",
            displayResId = R.drawable.feet_spread_out_intense_stretch_pose_3,
            description = "Stand with feet wide and hands clasped overhead. Fold forward at the hips until your hands touch the floor. Keep your arms extended to deepen the stretch.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Shoulders", "Hamstrings")
        ),
        Exercise(
            name = "Feet Spread Intense 4",
            displayResId = R.drawable.feet_spread_out_intense_stretch_pose_4,
            description = "Bend forward from a wide stance, placing hands in front of your feet. Lower your head toward the floor and raise your hips, straightening your legs as much as possible.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Feet Spread Stretch",
            displayResId = R.drawable.feet_spread_out_intense_stretch_pose_5,
            description = "With feet wide apart, place your hands in reverse prayer position behind your back. Bend forward, lowering your head toward the floor while lifting your joined palms up your back.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Feet Spread Stretch",
            displayResId = R.drawable.feet_spread_out_intense_stretch_pose_6,
            description = "Bend forward with feet wide apart until the top of your head nears the floor. Lift your hands from the ground and extend your arms upward at a 45-degree angle.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Spine", "Shoulders")
        ),
        Exercise(
            name = "Revolved Bound Fierce Pose",
            displayResId = R.drawable.fierce_pose_2_revolved_bound,
            description = "With feet shoulder-width apart, lower into a crouch and clasp your hands behind your back. Twist your torso to one side, lift your ribcage, and turn your gaze upward to open the chest.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Shoulders")
        ),
        Exercise(
            name = "Tiptoe Fierce Pose",
            displayResId = R.drawable.fierce_pose_3_tiptoe,
            description = "Stand with knees slightly bent and rise onto your tiptoes. Lift your arms overhead and lengthen your spine, maintaining balance and upright posture.",
            duration = 20,
            muscleGroups = listOf("Chest", "Calves", "Core", "Shoulders")
        ),
        Exercise(
            name = "Fierce Pose Extended Tiptoes",
            displayResId = R.drawable.fierce_pose_extended_tiptoes,
            description = "Lower into a side squat with one leg extended and hands on the floor. Lean your torso toward the bent leg, then lift your chest and extend one arm upward. Hold, then switch sides.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Glutes", "Obliques")
        ),
        Exercise(
            name = "Intense Wrist Fierce Pose",
            displayResId = R.drawable.fierce_pose_intense_wrist,
            description = "Crouch low to the floor and place your palms flat with fingers pointing back toward you. Gently shift your weight forward to stretch the wrists and forearms.",
            duration = 15,
            muscleGroups = listOf("Wrists", "Forearms", "Shoulders")
        ),
        Exercise(
            name = "Clasped Hands Revolved Fierce Pose",
            displayResId = R.drawable.fierce_pose_revolved_hands_clasped,
            description = "Crouch with feet shoulder-width apart. Clasp your hands behind your back and twist your torso to one side. Straighten your arms and raise your clasped hands to stretch your chest and shoulders.",
            duration = 15,
            muscleGroups = listOf("Spine", "Back", "Shoulders", "Chest")
        ),
        Exercise(
            name = "Fierce Pose Revolved One Leg Bound",
            displayResId = R.drawable.fierce_pose_revolved_one_leg_bound,
            description = "Crouch with knees bent and feet apart. Wrap one arm under your leg and the other behind your neck to form a bound clasp. Lift your chest and lengthen your spine. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Spine", "Hips", "Shoulders", "Chest")
        ),
        Exercise(
            name = "Fierce Forward Bend",
            displayResId = R.drawable.fierce_pose_tip_forward_bend,
            description = "Stand with knees slightly bent and rise onto your tiptoes. Bend forward at the waist, reaching toward the floor. Lift through the center of your spine to activate your upper back and chest.",
            duration = 20,
            muscleGroups = listOf("Chest", "Upper Back", "Hamstrings", "Calves")
        ),
        Exercise(
            name = "Finger Press Ahead",
            displayResId = R.drawable.finger_press_ahead,
            description = "Sit or stand tall with arms extended forward. Lace your fingers and press your palms outward, raising your hands just above eye level. Hold while keeping your shoulders relaxed.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Upper Back", "Wrists")
        ),
        Exercise(
            name = "Finger Press Downward",
            displayResId = R.drawable.finger_press_downward,
            description = "Lace your fingers in front of your body with palms facing out. Lower your arms to hip level and press outward gently to stretch through the shoulders and forearms.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Forearms")
        ),
        Exercise(
            name = "Finger Press Overhead",
            displayResId = R.drawable.finger_press_overhead,
            description = "Extend your arms overhead with fingers interlaced and palms facing the ceiling. Hold the stretch while maintaining length through the spine.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Spine", "Upper Back")
        ),
        Exercise(
            name = "Shoulder Height Finger Press",
            displayResId = R.drawable.finger_press_shoulder_height,
            description = "Extend your arms forward at shoulder height with fingers laced and palms facing outward. Hold the stretch to activate shoulders and upper arms.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Arms")
        ),
        Exercise(
            name = "Forearm Stretch Fingers Laced",
            displayResId = R.drawable.forearm_stretch_fingers_laced,
            description = "Kneel with toes pointed behind you. Lace your fingers and press your palms downward toward your lap to stretch the wrists and forearms.",
            duration = 30,
            muscleGroups = listOf("Forearms", "Wrists", "Triceps")
        ),
        Exercise(
            name = "Laced Fingers Raised Forearm Stretch",
            displayResId = R.drawable.forearm_stretch_fingers_laced_and_raised,
            description = "Sit cross-legged or stand tall. Raise your arms to shoulder height, lace your fingers, and press your palms forward to stretch your wrists and forearms.",
            duration = 30,
            muscleGroups = listOf("Forearms", "Wrists", "Shoulders")
        ),
        Exercise(
            name = "Laced Fingers Raised Stretch",
            displayResId = R.drawable.forearm_stretch_fingers_laced_and_raised_copy,
            description = "Maintain an upright seated or standing posture. Raise your arms to shoulder height, interlace your fingers, and extend your palms forward. Hold the stretch while keeping shoulders neutral.",
            duration = 30,
            muscleGroups = listOf("Forearms", "Wrists", "Shoulders")
        ),
        Exercise(
            name = "Forearm Stretch Palm to Wall",
            displayResId = R.drawable.forearm_stretch_palm_to_wall,
            description = "Stand beside a wall and extend your arm fully with your palm flat against the surface, fingers pointing downward. Gently press into the wall to deepen the forearm stretch.",
            duration = 30,
            muscleGroups = listOf("Forearms", "Wrists")
        ),
        Exercise(
            name = "Forearm Stretch Seated",
            displayResId = R.drawable.forearm_stretch_seated,
            description = "Sit on a chair and place your palms flat on the seat beside you, fingers pointed behind. Press into the seat to stretch the forearms and gently engage the triceps.",
            duration = 30,
            muscleGroups = listOf("Forearms", "Triceps")
        ),
        Exercise(
            name = "Forward Bend Assisted",
            displayResId = R.drawable.forward_bend_assisted,
            description = "Stand with legs wide apart and fold forward from the hips. Place your hands on the floor or a yoga block between your legs. Relax into the stretch while keeping your back flat.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Lower Back", "Glutes")
        ),
        Exercise(
            name = "Crossed Arm Forward Bend",
            displayResId = R.drawable.forward_bend_crossed_arm,
            description = "Stand tall with feet together and cross your arms at the elbows. Fold forward, letting your head drop toward the floor. Deepen the stretch by reaching opposite hands toward your feet.",
            duration = 20,
            muscleGroups = listOf("Spine", "Upper Back", "Hamstrings")
        ),
        Exercise(
            name = "Crossed Arms Forward Bend (Advanced)",
            displayResId = R.drawable.forward_bend_crossed_arms_advanced,
            description = "With feet shoulder-width apart, bend forward and cross your arms beneath you. Reach to tuck your fingers under the opposite foot, deepening the stretch through the hamstrings and lower back.",
            duration = 15,
            muscleGroups = listOf("Hamstrings", "Lower Back", "Spine")
        ),
        Exercise(
            name = "Flat Back Stretch on Ball",
            displayResId = R.drawable.forward_bend_flat_back_on_ball_or_chair,
            description = "Sit on an exercise ball or chair with legs spread wide. Clasp your hands behind your head and fold forward with a flat back, gently pressing down on your head to deepen the stretch.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Forward Bend Legs Apart 1",
            displayResId = R.drawable.forward_bend_legs_apart_1,
            description = "Step one foot forward and keep both feet pointed ahead. Bend forward at the waist and reach for your front ankle, gently drawing your torso closer to the floor. Switch legs after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Calves", "Glutes")
        ),
        Exercise(
            name = "Forward Bend Legs Apart 2",
            displayResId = R.drawable.forward_bend_legs_apart_2,
            description = "With one foot stepped forward, bend at the waist and reach for your front calf. Use gentle pressure to deepen the fold. Maintain a long spine as you stretch. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Calves", "Lower Back")
        ),
        Exercise(
            name = "Legs Apart Forward Fold",
            displayResId = R.drawable.forward_bend_legs_apart_hands_to_knee,
            description = "From a standing position, step one foot forward and reach for your front knee as you fold at the hips. Keep your back flat and use your hands for support. Alternate sides after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Glutes", "Spine")
        ),
        Exercise(
            name = "Revolved Prayer in Forward Bend",
            displayResId = R.drawable.forward_bend_legs_apart_revolved_prayer,
            description = "Step one foot forward with both feet facing ahead. Bend at the waist and reach around the front leg, joining your hands in prayer behind the knee. Gently twist toward the front leg and hold. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Spine", "Obliques")
        ),
        Exercise(
            name = "Forward Lunge Arms Spread Out",
            displayResId = R.drawable.forward_lunge_arms_spread_out,
            description = "From a low squat, extend one leg back with the toes tucked under. Lean forward into a deep lunge, pressing the back thigh toward the floor and stretching the hamstrings. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Hip Flexors", "Glutes")
        ),
        Exercise(
            name = "Forward Lunge Lat Pose",
            displayResId = R.drawable.forward_lunge_lat_stretch,
            description = "From a wide squat with hands on the floor, cross one arm over the other and place it beside the opposite foot. Twist your torso in that direction to stretch the lats and side body.",
            duration = 30,
            muscleGroups = listOf("Latissimus Dorsi", "Obliques", "Spine")
        ),
        Exercise(
            name = "Forward Lunge Prep",
            displayResId = R.drawable.forward_lunge_prep,
            description = "Start in a kneeling position and step one leg far forward into a deep lunge. Keep the back foot lifted on the toes and place both hands beside the front foot for support. Lower the hips and hold. Alternate sides.",
            duration = 15,
            muscleGroups = listOf("Quadriceps", "Hip Flexors", "Glutes")
        ),
        Exercise(
            name = "Four Corner Stretch",
            displayResId = R.drawable.four_corner_stretch,
            description = "Sit cross-legged and lift one foot onto the opposite thigh. Wrap both hands around the lifted calf and pull it gently until it's parallel to the floor. Hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Abductors", "Hips", "Glutes")
        ),
        Exercise(
            name = "Four Corner Stretch 1",
            displayResId = R.drawable.four_corner_stretch_1,
            description = "Begin seated cross-legged with one leg on top. Hook your arm under the raised calf and lift it until parallel to the floor. Bring your hands together above your head and hold the pose before switching legs.",
            duration = 30,
            muscleGroups = listOf("Abductors", "Hips", "Shoulders")
        ),
        Exercise(
            name = "One-Legged Staff Pose",
            displayResId = R.drawable.four_limbs_staff_pose_one_legged,
            description = "Begin in a plank position with hands under shoulders and feet extended. Engage your core and lift one foot, resting it gently on the back of the opposite ankle. Maintain a straight line from heels to shoulders.",
            duration = 20,
            muscleGroups = listOf("Chest", "Core", "Shoulders", "Triceps")
        ),
        Exercise(
            name = "Frog Leg Straddle",
            displayResId = R.drawable.frog_leg_inverted_straddle,
            description = "Lie on your back with knees bent and opened to the sides, feet pressed together. Gently press down on your inner thighs to deepen the stretch and open the hips.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Groin", "Hips")
        ),
        Exercise(
            name = "Frog Splits",
            displayResId = R.drawable.frog_splits,
            description = "Start on all fours and lower your forearms to the ground. Spread your knees apart and lower your hips toward the floor, bringing the soles of your feet together. Hold the position to open the hips.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Inner Thighs", "Hips")
        ),
        Exercise(
            name = "Frog Splits Advanced",
            displayResId = R.drawable.frog_splits_advanced,
            description = "Begin kneeling and extend one leg forward. Gently lower into a forward split, letting gravity deepen the stretch. Go as far as comfortable, then push yourself back up. Alternate legs.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Hip Flexors", "Hamstrings")
        ),
        Exercise(
            name = "Assisted Forward Bend",
            displayResId = R.drawable.frog_splits_advanced_1,
            description = "Stand beside a chair with one foot on the seat and the other grounded. Bend at the hips and reach toward the floor to stretch through the inner thighs and spine. Switch legs after holding.",
            duration = 15,
            muscleGroups = listOf("Spine", "Adductors", "Hamstrings")
        ),
        Exercise(
            name = "Garland Pose 1",
            displayResId = R.drawable.garland_pose_advanced_variation_1,
            description = "Squat low with knees together and hips resting on your heels. Lower your chest forward until it's parallel to the floor. Let your shoulders and neck relax so the crown of your head rests on the floor. Reach your arms back and clasp your hands behind your feet.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Spine", "Hips")
        ),
        Exercise(
            name = "Garland Pose 2",
            displayResId = R.drawable.garland_pose_advanced_variation_2,
            description = "In a deep squat with hips on your heels, lower your torso until parallel with the floor. Drop your shoulders and head down, then clasp your hands behind your back and lift them upward to stretch the spine and shoulders.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Garland Pose 3",
            displayResId = R.drawable.garland_pose_advanced_variation_3,
            description = "From a deep squat, lower your chest forward and let your shoulders and neck drop. Rest the top of your head toward the floor. Bring your hands onto your back with palms facing the ceiling and hold the position.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Spine", "Shoulders")
        ),
        Exercise(
            name = "Garland Pose 4",
            displayResId = R.drawable.garland_pose_advanced_variation_4,
            description = "Squat with knees together and chest lowered. Rest the top of your head on the ground and bring your elbows to the floor. Place palms together behind your head with fingers pointing upward. Breathe deeply and hold.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Neck", "Spine")
        ),
        Exercise(
            name = "Garland Pose 5",
            displayResId = R.drawable.garland_pose_advanced_variation_5,
            description = "In a low squat, drop your chest and rest the top of your head on the floor. Reach your arms behind you with palms facing the ceiling to deepen the stretch through your upper back and shoulders.",
            duration = 15,
            muscleGroups = listOf("Upper Back", "Shoulders", "Neck")
        ),
        Exercise(
            name = "Garland Pose Balance Prep",
            displayResId = R.drawable.garland_pose_balance_prep,
            description = "Lower into a deep squat with hips resting on heels. Once balanced, raise your arms in front of your chest with palms pressed together. Maintain posture and balance as you hold.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Core", "Hips")
        ),
        Exercise(
            name = "Garland Pose Wrist Stretch",
            displayResId = R.drawable.garland_pose_intense_wrist_stretch,
            description = "Squat low with knees together. Place your hands flat on the floor in front of you with fingers pointing backward. Gently lean into your hands for an intense forearm and wrist stretch.",
            duration = 20,
            muscleGroups = listOf("Wrists", "Forearms", "Upper Back")
        ),
        Exercise(
            name = "Garland Pose Squat",
            displayResId = R.drawable.garland_pose_squat,
            description = "Squat low with knees together and hips on your heels. Bring your palms together in front of your chest and raise your arms forward. Focus on balance and spine alignment while holding.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Hips", "Spine")
        ),
        Exercise(
            name = "Garuda Legs",
            displayResId = R.drawable.garuda_legs,
            description = "Lie back on your elbows with knees bent. Cross one leg over the other, tucking the foot behind the opposite ankle. Raise the supporting heel onto tiptoes. Extend the same-side arm overhead and gaze upward to open the chest.",
            duration = 30,
            muscleGroups = listOf("Chest", "Hips", "Spine")
        ),
        Exercise(
            name = "Gate Pose",
            displayResId = R.drawable.gate_pose,
            description = "Begin in a kneeling position. Extend one leg to the side and plant the same-side hand on the floor near the thigh. Reach the opposite arm overhead and stretch laterally while turning your gaze upward.",
            duration = 15,
            muscleGroups = listOf("Chest", "Obliques", "Spine")
        ),
        Exercise(
            name = "Revolved Bound Gate Pose",
            displayResId = R.drawable.gate_pose_revolved_bound,
            description = "From a kneeling position, extend one leg to the side. Lower your torso toward that leg, threading one arm under and behind the thigh while reaching the other across your back to clasp hands. Gaze upward to open the shoulders.",
            duration = 15,
            muscleGroups = listOf("Obliques", "Chest", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Half Windmill",
            displayResId = R.drawable.hald_windmill_modification,
            description = "Step forward with one foot while lifting the opposite arm overhead and lowering the other to your hip. Alternate arm and leg movements with each step for dynamic shoulder and spinal engagement.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Spine", "Core")
        ),
        Exercise(
            name = "Half Bound Sideways",
            displayResId = R.drawable.half_bound_sideways_easy_leg_position_of_cow_face_pose_2,
            description = "Sit cross-legged and lift one foot into the opposite hip crease. Hold the foot with the opposite hand and lean back, placing your forearm behind you. Twist your chest and shoulders in the direction of the lifted foot. Hold, then switch sides.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Hips")
        ),
        Exercise(
            name = "Knee-Up Half Eastern Stretch",
            displayResId = R.drawable.half_eastern_intense_stretch_pose_knee_up,
            description = "Seated with knees bent and hands behind you, press into the floor to lift your hips. Cross one foot over the opposite knee. Drop your head back and draw your chest upward to deepen the stretch.",
            duration = 20,
            muscleGroups = listOf("Abdominals", "Chest", "Shoulders")
        ),
        Exercise(
            name = "Half Hero Bound Angle",
            displayResId = R.drawable.half_hero_bound_half_bound_angle_variation,
            description = "Sit with one leg bent behind you and the other foot tucked into your groin. Lean back slowly onto your elbows, then onto your back. Extend your arms out to the sides and hold.",
            duration = 20,
            muscleGroups = listOf("Chest", "Hip Flexors", "Spine")
        ),
        Exercise(
            name = "Half Hero Bound 2",
            displayResId = R.drawable.half_hero_bound_halfbound_angle_variation_2,
            description = "Sit with one leg bent behind and the other foot at your groin. Recline back onto your elbows, then rest your shoulders and head on the floor. Extend your arms and straighten the front leg to deepen the stretch.",
            duration = 20,
            muscleGroups = listOf("Chest", "Hip Flexors", "Spine")
        ),
        Exercise(
            name = "Half Hero Half Bound",
            displayResId = R.drawable.half_hero_half_bound_angle_stretch,
            description = "From a seated position with one leg bent behind and the other at your groin, lean back onto your elbows. Reach one arm behind your back and touch your opposite hip, opening the chest and shoulder. Switch sides after holding.",
            duration = 15,
            muscleGroups = listOf("Chest", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Reclined Half Hero Stretch",
            displayResId = R.drawable.half_hero_half_extended_hand_to_foot_pose_reclined_variation,
            description = "Start kneeling and extend one leg out to the side. Lower your hips onto the heel of your bent leg. Fold forward, extending both arms outward and bringing your forehead toward the floor.",
            duration = 15,
            muscleGroups = listOf("Hamstrings", "Spine", "Adductors")
        ),
        Exercise(
            name = "Bound Half Intense Pose",
            displayResId = R.drawable.half_intense_stretch_pose_hands_bound_uneven_legs,
            description = "Stand with feet shoulder-width apart and clasp your hands behind your back. Lift one heel onto tiptoes, then fold forward from the waist while twisting slightly to the side. Keep your back flat and chest open as you hold.",
            duration = 20,
            muscleGroups = listOf("Chest", "Hamstrings", "Shoulders")
        ),
        Exercise(
            name = "Reverse Prayer Half Pose",
            displayResId = R.drawable.half_intense_stretch_pose_reverse_prayer_uneven_leg,
            description = "Stand tall and bring your palms together behind your back in reverse prayer position. Lift one heel and bend forward at the waist while maintaining balance and a flat back. Alternate legs after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Shoulders", "Chest")
        ),
        Exercise(
            name = "Uneven Leg Half Intense Pose",
            displayResId = R.drawable.half_intense_stretch_pose_reverse_prayer_uneven_legs,
            description = "Join your palms in reverse prayer behind your back. Raise one foot onto tiptoes and bend forward from the waist, keeping your back flat. Hold the pose, then switch sides.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Shoulders", "Spine")
        ),
        Exercise(
            name = "Half Intense Revolved",
            displayResId = R.drawable.half_intense_stretch_pose_revolved_uneven_legs,
            description = "Stand upright with arms extended. Raise one heel and bend forward, twisting your torso until one hand touches the floor and the other reaches toward the ceiling. Hold the twist, then repeat on the other side.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Obliques", "Spine")
        ),
        Exercise(
            name = "Half Intense Pose Sideways",
            displayResId = R.drawable.half_intense_stretch_pose_sideways,
            description = "Stand with feet together and arms extended overhead. Fold forward and reach your clasped hands to the outside of one foot, creating a side bend through the waist. Hold, then alternate sides.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Half Lotus Pose - Sage Vasistha",
            displayResId = R.drawable.half_lotus_pose_dedicated_to_sage_vasistha,
            description = "Start kneeling, then place one foot into a half lotus position on the opposite thigh. Extend the other leg out to the side. Lean to the side, placing one hand on the ground and stretching the other overhead. Gaze upward and hold.",
            duration = 15,
            muscleGroups = listOf("Obliques", "Hips", "Spine")
        ),
        Exercise(
            name = "Bent Hand to Foot Half Moon",
            displayResId = R.drawable.half_moon_bent_hand_to_foot_copy,
            description = "Stand tall with arms extended. Shift your weight to one leg, lean forward, and lift the opposite leg behind you. Twist your torso, place one hand on the floor, and reach the other overhead. Bend the lifted leg and grab the foot, pressing it upward to deepen the chest and shoulder stretch.",
            duration = 15,
            muscleGroups = listOf("Chest", "Hamstrings", "Glutes", "Shoulders")
        ),
        Exercise(
            name = "Half Moon with Bal",
            displayResId = R.drawable.half_moon_bent_hand_to_foot_with_ball,
            description = "Shift your weight onto one leg and hinge forward, raising the other leg behind you. Place one hand on the floor for support and extend the opposite arm upward. Bend the lifted leg, grab your foot, and push it upward to deepen the stretch. Gaze up and hold.",
            duration = 15,
            muscleGroups = listOf("Chest", "Shoulders", "Glutes", "Hamstrings")
        ),
        Exercise(
            name = "Half Moon Pose",
            displayResId = R.drawable.half_moon_pose,
            description = "Step one foot forward and shift your weight onto it. Hinge at the hips, lifting your back leg and lowering one hand to the floor. Extend the opposite arm upward, opening the chest and stacking the shoulders. Hold and repeat on the other side.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Glutes", "Hamstrings")
        ),
        Exercise(
            name = "Half One Leg Upward",
            displayResId = R.drawable.half_one_leg_stretched_upward,
            description = "From a standing position, fold forward and place your hands flat on the floor. Shift your weight onto your hands and raise one leg straight upward. Keep the raised leg engaged and pointed. Hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Glutes", "Hamstrings", "Shoulders")
        ),
        Exercise(
            name = "Half Split",
            displayResId = R.drawable.half_split,
            description = "Sit on the floor with one leg extended to the side and the other bent behind you. Twist your torso toward the bent leg and reach back with the same-side arm. Breathe into the stretch and hold before switching sides.",
            duration = 30,
            muscleGroups = listOf("Adductors", "Hip Flexors", "Spine")
        ),
        Exercise(
            name = "Half Split Modification",
            displayResId = R.drawable.half_split_modification,
            description = "From a low squat, extend one leg to the side while keeping the other bent behind you. Sit into the stretch and flex the toes of the extended leg upward. Twist your torso toward the bent leg and hold.",
            duration = 30,
            muscleGroups = listOf("Adductors", "Hamstrings", "Hips")
        ),
        Exercise(
            name = "Half Split Standing",
            displayResId = R.drawable.half_split_standing,
            description = "Stand beside a sturdy chair. Raise one leg and rest your ankle on the back of the chair. Keep your posture upright and hold the stretch through the inner thigh. Switch legs after holding.",
            duration = 10,
            muscleGroups = listOf("Adductors", "Hamstrings", "Glutes")
        ),
        Exercise(
            name = "Forward Bend Half Split",
            displayResId = R.drawable.half_split_with_forward_bend,
            description = "Sit on the floor with one leg extended to the side and the other bent behind you. Twist toward the extended leg and fold forward, bringing your head toward the knee. Hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Adductors", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Half Straddle",
            displayResId = R.drawable.half_straddle,
            description = "From a seated position, extend one leg out to the side and bend the opposite foot into your groin. Place your hands behind you for support and hold the stretch. Switch legs after holding.",
            duration = 30,
            muscleGroups = listOf("Adductors", "Hips")
        ),
        Exercise(
            name = "Stacked Hamstring & Calf Reach",
            displayResId = R.drawable.hamstring_and_calf_stacked_stretch_and_reach,
            description = "Sit with legs extended. Stack one heel over the opposite foot and fold forward from the hips, reaching toward the front ankle while keeping knees straight. Switch sides after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Calves", "Lower Back")
        ),
        Exercise(
            name = "Hamstring Inverted",
            displayResId = R.drawable.hamstring_inverted,
            description = "Stand tall and shift your weight to one foot. Hinge forward at the waist while raising the opposite leg behind you until your torso and leg form a straight line. Balance and hold before switching sides.",
            duration = 10,
            muscleGroups = listOf("Hamstrings", "Glutes", "Spine")
        ),
        Exercise(
            name = "Hamstring Stretch 90-90",
            displayResId = R.drawable.hamstring_stretch_9090,
            description = "Lie flat on your back and bring one knee into your chest. Wrap your hands behind the thigh and gently pull the leg closer to deepen the stretch. Repeat with the other leg.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Glutes")
        ),
        Exercise(
            name = "Knee-to-Chest Hamstring Stretch",
            displayResId = R.drawable.hamstring_stretch_knee_to_chest,
            description = "From a seated position, bend one knee and rest the foot on the opposite thigh. Pull the bent leg toward your chest with both hands, then hold and switch sides.",
            duration = 10,
            muscleGroups = listOf("Hamstrings", "Glutes", "Hips")
        ),
        Exercise(
            name = "Raised Knee & Toe Hamstring",
            displayResId = R.drawable.hamstring_stretch_toe_raised_kneeling,
            description = "Start in a kneeling position and extend one leg forward, resting on the heel with toes flexed. Reach toward the toes with one hand to deepen the stretch. Alternate sides.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Calves")
        ),
        Exercise(
            name = "Hamstring Stretch with Band",
            displayResId = R.drawable.hamstring_stretch_with_band_or_towel,
            description = "Lie on your back and wrap a towel or band around one foot. Gently pull the foot toward you while keeping the leg straight. Hold and switch sides.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Calves", "Lower Back")
        ),
        Exercise(
            name = "Hamstring Toe Pointed",
            displayResId = R.drawable.hamstring_toe_pointed,
            description = "Stand tall and step one foot forward, flexing the toes. Place your hands on the forward thigh and bend your back knee to deepen the stretch. Alternate legs after holding.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Calves", "Glutes")
        ),
        Exercise(
            name = "Hamstring Toe Touch",
            displayResId = R.drawable.hamstring_toe_touch,
            description = "Stand facing a chair and rest one heel on the seat. Keep the leg straight and fold forward from the hips to reach toward your toes. Switch legs after holding.",
            duration = 15,
            muscleGroups = listOf("Hamstrings", "Calves", "Lower Back")
        ),
        Exercise(
            name = "Hand Crossover",
            displayResId = R.drawable.hand_crossover,
            description = "Stand tall with one arm raised and the other extended downward. Swing both arms across each other in opposite directions and return to start. Repeat in a fluid, alternating motion.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Upper Back", "Arms")
        ),
        Exercise(
            name = "Garuda Hand Position",
            displayResId = R.drawable.hand_position_of_the_pose_dedictated_to_garuda_in_half_intense_stretch,
            description = "Stand with ankles crossed and wrists twisted in a prayer position. Hinge forward at the waist, twist your torso to one side, and reach your fingertips toward the floor. Hold, then repeat on the opposite side.",
            duration = 10,
            muscleGroups = listOf("Hamstrings", "Spine", "Shoulders")
        ),
        Exercise(
            name = "Hand to Foot One-Leg Half Pose",
            displayResId = R.drawable.hand_to_foot_one_legged_half_intense_stretch_pose,
            description = "Stand tall and raise one foot behind you, pressing it into your hip with the same-side hand. Hinge forward and place your opposite hand on the floor for balance. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Hamstrings", "Glutes", "Balance")
        ),
        Exercise(
            name = "Hand Crossover",
            displayResId = R.drawable.hand_crossover,
            description = "Stand tall with one arm raised and the other extended downward. Swing both arms across each other in opposite directions and return to start. Repeat in a fluid, alternating motion.",
            duration = 30,
            muscleGroups = listOf("Shoulders", "Upper Back", "Arms")
        ),
        Exercise(
            name = "Hands Bound Half Pose",
            displayResId = R.drawable.hands_bound_half_eastern_intense_stretch_pose,
            description = "Sit with knees bent and lean back onto your elbows. Bind your forearms together and lift your hips, stepping your feet away to align knees, hips, and shoulders. Place one foot on the opposite knee and open the chest. Hold, then switch legs.",
            duration = 15,
            muscleGroups = listOf("Abdominals", "Chest", "Hip Flexors")
        ),
        Exercise(
            name = "Bound One-Legged Pose",
            displayResId = R.drawable.hands_bound_one_legged_half_eastern_intense_stretch_pose,
            description = "Seated with knees bent, lean onto your elbows and bind your forearms. Lift your hips and align your torso. Draw your shoulders back and drop your head to deepen the chest and neck stretch. Hold steadily.",
            duration = 15,
            muscleGroups = listOf("Abdominals", "Chest", "Neck")
        ),
        Exercise(
            name = "Hands Bound Forward Stretch",
            displayResId = R.drawable.hands_bount_forward_stretch_moidification,
            description = "Stand with feet together and clasp your hands behind your back. Bend your knees and fold forward, extending your arms overhead as your torso rests on your thighs. Hold and breathe.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Shoulders", "Upper Back")
        ),
        Exercise(
            name = "Head to Knee Pose",
            displayResId = R.drawable.head_to_knee_pose_both_hands_to_ankle,
            description = "Sit with one leg extended and the opposite foot tucked into the inner thigh. Fold forward from the waist, reaching both hands toward the ankle of the extended leg. Gently pull your torso closer and hold before switching sides.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Spine", "Lower Back")
        ),
        Exercise(
            name = "Head to Knee Pose Prep",
            displayResId = R.drawable.head_to_knee_pose_prep,
            description = "Seated with one leg extended and the opposite foot tucked in, flex your toes and place your hands behind you for support. Sit tall and hold to gently activate the hamstrings and hips.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Hips")
        ),
        Exercise(
            name = "Head to Knee Pose Revolved",
            displayResId = R.drawable.head_to_knee_pose_revolved,
            description = "Sit with one leg extended and the opposite foot tucked into the groin. Reach toward the foot with the same-side hand and twist your torso slightly as you fold forward. Hold and alternate sides.",
            duration = 20,
            muscleGroups = listOf("Hamstrings", "Spine", "Obliques")
        ),
        Exercise(
            name = "Head to Knee Sideways",
            displayResId = R.drawable.head_to_knee_sideways,
            description = "Sit with one leg extended to the side and the opposite foot tucked in. Raise your arms overhead, then side-bend toward the extended leg, resting one hand on the ground. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Obliques", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Headstand Prep",
            displayResId = R.drawable.headstand_prep,
            description = "Kneel on the floor and place your palms on the ground. Lower the crown of your head between your hands. Lift your knees and walk your feet closer, creating an inverted V-shape. Hold and focus on balance.",
            duration = 10,
            muscleGroups = listOf("Core", "Shoulders", "Neck")
        ),
        Exercise(
            name = "Headstand Prep (Wrist)",
            displayResId = R.drawable.headstand_prep_inense_wrist,
            description = "Set up for a headstand with palms facing backward and fingers toward your knees to deepen the wrist stretch. Lift your hips into an inverted V and hold the position with control.",
            duration = 10,
            muscleGroups = listOf("Wrist Flexors", "Shoulders", "Core")
        ),
        Exercise(
            name = "High Knees",
            displayResId = R.drawable.high_knees,
            description = "Stand with feet hip-width apart. Rapidly lift one knee toward your chest while pumping your arms. Alternate knees quickly as you move in place or forward, keeping your core engaged and chest lifted.",
            duration = 30,
            muscleGroups = listOf("Cardio", "Hip Flexors", "Core", "Legs")
        ),
        Exercise(
            name = "Hip Extensors Seated",
            displayResId = R.drawable.hip_extensor_stretch_seated,
            description = "Sit on the floor with your legs wide apart. Bend one leg inward, placing the foot near your groin. Place your hands on the floor in front of you and gently lean forward. Hold, then switch sides.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Hip Extensors", "Lower Back")
        ),
        Exercise(
            name = "Hip Internal Rotation",
            displayResId = R.drawable.hip_internal_rotation,
            description = "Lie on your back with knees bent and feet apart. Keeping your feet flat on the floor, bring your knees together to internally rotate the hips. Return to start and repeat.",
            duration = 20,
            muscleGroups = listOf("Abductors", "Hip Rotators")
        ),
        Exercise(
            name = "Alternating Internal Hip Rotation",
            displayResId = R.drawable.hip_internal_rotator_alternating_legs,
            description = "Lie on your back with knees bent and feet shoulder-width apart. Rotate one knee inward at a time, keeping feet planted. Alternate legs and repeat for multiple reps.",
            duration = 30,
            muscleGroups = listOf("Abductors", "Hip Rotators", "Glutes")
        ),
        Exercise(
            name = "Hip Raise",
            displayResId = R.drawable.hip_raise,
            description = "Lie on your back with knees bent and legs lifted toward the ceiling. Engage your core and use your upper back to lift your hips, extending your legs overhead. Hold, then lower back down.",
            duration = 30,
            muscleGroups = listOf("Abdominals", "Hip Flexors", "Core")
        ),
        Exercise(
            name = "Hip Raise Twist",
            displayResId = R.drawable.hip_raise_twist,
            description = "Lie on your back with knees bent. Place one hand flat on the floor for support. Engage your core and twist your torso in the opposite direction. Hold, then alternate sides.",
            duration = 15,
            muscleGroups = listOf("Latissimus Dorsi", "Obliques", "Core")
        ),
        Exercise(
            name = "Hip Rotation",
            displayResId = R.drawable.hip_rotation,
            description = "Stand with legs apart and hands on hips. Rotate your torso side to side while keeping your feet grounded and spine tall. Repeat with controlled motion to warm up or loosen the hips.",
            duration = 30,
            muscleGroups = listOf("Abductors", "Obliques", "Hip Rotators")
        ),
        Exercise(
            name = "Arms Up Hip-Thigh Lunge",
            displayResId = R.drawable.hip_to_thing_lunge_arms_up,
            description = "From a kneeling position, step one leg forward into a deep lunge. Clasp your hands and extend your arms overhead, pushing your hips downward to deepen the stretch. Hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Quadriceps", "Hip Flexors", "Spine")
        ),
        Exercise(
            name = "Hip Twist",
            displayResId = R.drawable.hip_twist,
            description = "Step forward into a deep lunge and place both hands on the floor. Press one shoulder upward and twist your torso to deepen the spinal stretch. Hold, then alternate sides.",
            duration = 20,
            muscleGroups = listOf("Spine", "Hip Flexors", "Glutes")
        ),
        Exercise(
            name = "Horizontal Angle Split",
            displayResId = R.drawable.horizontal_split_reclined_side_angle,
            description = "Lie on your back and raise your legs vertically. Grab your feet and gently open your legs into a wide split, pulling downward slightly to deepen the stretch. Hold and breathe.",
            duration = 30,
            muscleGroups = listOf("Adductors", "Hamstrings", "Lower Back")
        ),
        Exercise(
            name = "Iliopsoas Self Stretch",
            displayResId = R.drawable.iliopsoas_self_stretch,
            description = "Sit in a butterfly position. Lift one leg and wrap your arm underneath the shin to hold your foot. Gently pull your foot toward your chest and hold, then alternate legs.",
            duration = 30,
            muscleGroups = listOf("Glutes", "Hip Flexors", "Adductors")
        ),
        Exercise(
            name = "Intense Ankle",
            displayResId = R.drawable.intense_ankle_stretch_extended_leg_to_side_1,
            description = "Lower into a side squat with one leg extended. Lean forward and place your hands on the floor in front of you, facing the direction of the extended leg. Hold and switch sides.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Ankles", "Hips")
        ),
        Exercise(
            name = "Overhead Intense Ankle Pose",
            displayResId = R.drawable.intense_ankle_stretch_extended_leg_to_side_tiptoe_arms_overhead,
            description = "From a side squat position with one leg extended, bring your hands into prayer and raise them overhead. Bend slightly toward the grounded leg and hold the stretch before alternating.",
            duration = 20,
            muscleGroups = listOf("Adductors", "Obliques", "Hips")
        ),
        Exercise(
            name = "Intense Side Pose",
            displayResId = R.drawable.intense_side_stretch_pose,
            description = "Step back into a wide stance and twist your torso toward the front leg. Bend forward at the waist and drop your hands to the floor, folding deeply along the front leg. Hold, then switch sides.",
            duration = 15,
            muscleGroups = listOf("Obliques", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Intense Side Pose Prep",
            displayResId = R.drawable.intense_side_stretch_pose_prep,
            description = "Step one foot forward with both legs straight. Fold forward from the hips and slide your hands down the front leg. Reach the opposite hand behind the ankle and extend the rear arm behind you. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Hamstrings", "Spine")
        ),
        Exercise(
            name = "Intense Side Pose Prep",
            displayResId = R.drawable.intense_side_stretch_pose_prep_modification,
            description = "With one foot stepped forward and both legs straight, fold your torso forward until it's parallel to the floor. Slide your hands down the front leg and maintain a long spine. Hold.",
            duration = 30,
            muscleGroups = listOf("Upper Back", "Hamstrings")
        ),
        Exercise(
            name = "Prayer Hands Side Stretch",
            displayResId = R.drawable.intense_side_stretch_with_prayer_hands,
            description = "Step one foot back, fold over the front leg, and twist your torso to align with the front thigh. Bring your hands into prayer behind the front leg and hold. Switch sides.",
            duration = 30,
            muscleGroups = listOf("Obliques", "Spine", "Hamstrings")
        ),
        Exercise(
            name = "Chest Opening Intense Stretch",
            displayResId = R.drawable.intense_stretch_pose_with_chest_opener,
            description = "Stand with legs apart. Fold forward and reach one hand to the opposite foot. With your other hand on the floor, twist your torso open. Hold and alternate sides.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Hamstrings")
        ),
        Exercise(
            name = "Intense Stretch Pose Bound",
            displayResId = R.drawable.intense_stretch_pose_with_chest_opener_bound,
            description = "Fold forward with legs hip-width apart and reach one hand to the opposite foot. Rest the other hand on the floor beside the grounded foot and hold the twist.",
            duration = 15,
            muscleGroups = listOf("Chest", "Hamstrings", "Spine")
        ),
        Exercise(
            name = "Intense Pose Bound and Twisted",
            displayResId = R.drawable.intense_stretch_pose_with_chest_opener_bound_and_twisted,
            description = "Stand with one leg crossed in front of the other. Fold forward and reach across to hold both ankles. Twist deeply through the torso and hold.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Hamstrings")
        ),
        Exercise(
            name = "Forward Bend Triangle Pose",
            displayResId = R.drawable.intense_triangle_pose_revolved_forward_bend,
            description = "With legs in a wide stance, fold forward and reach across to hold the opposite ankle. Twist your torso and open your arm toward the sky. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Chest", "Obliques", "Hamstrings")
        ),
        Exercise(
            name = "Revolved Triangle Prep",
            displayResId = R.drawable.intense_triangle_pose_revolved_forward_bend_prep,
            description = "Step into a triangle stance. Reach one hand to the opposite ankle, then twist your torso and extend your opposite arm upward. Hold before switching sides.",
            duration = 10,
            muscleGroups = listOf("Chest", "Spine", "Hamstrings")
        ),
        Exercise(
            name = "One-Sided Intense Triangle",
            displayResId = R.drawable.intense_triangle_pose_revolved_to_one_side,
            description = "From a wide stance, fold forward and twist your torso to reach both hands toward the back foot. Hold the deep twist and repeat on the opposite side.",
            duration = 15,
            muscleGroups = listOf("Chest", "Spine", "Hamstrings")
        ),
        Exercise(
            name = "Intense Wrist Crane",
            displayResId = R.drawable.intense_wrist_crane_pose,
            description = "Crouch low with palms flat and fingers pointed toward you. Rise onto your tiptoes, lifting your hips. Hold to stretch the wrists.",
            duration = 15,
            muscleGroups = listOf("Wrists")
        ),
        Exercise(
            name = "Interlaced Finger",
            displayResId = R.drawable.interlaced_finger_stretch,
            description = "Interlace your fingers, extend arms forward with palms out. Raise arms to shoulder height and hold to stretch the wrists and shoulders.",
            duration = 30,
            muscleGroups = listOf("Wrists")
        ),
        Exercise(
            name = "Inverse Plank Chest Opener",
            displayResId = R.drawable.inverse_plank_chest_opener,
            description = "Sit with legs extended and palms on the floor behind you. Lift your hips, straighten your legs, and hold to open the chest and engage the core.",
            duration = 10,
            muscleGroups = listOf("Chest")
        ),
        Exercise(
            name = "IT Side Stretch",
            displayResId = R.drawable.it_side_stretch,
            description = "Lie on your side, bend the top leg behind you and grab the foot. Extend the shoulder and pull the foot away to stretch the IT band.",
            duration = 20,
            muscleGroups = listOf("Obliques")
        ),
        Exercise(
            name = "Kali Squat Hands Bound",
            displayResId = R.drawable.kali_squat_hands_bound_to_leg,
            description = "In a deep squat, bend forward and bind your arms under and behind your leg. Clasp hands together behind your back and hold.",
            duration = 20,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kali Squat Revolved",
            displayResId = R.drawable.kali_squat_revolved,
            description = "Lower into a deep squat and fold forward. Place hands on knees and twist the torso to one side. Hold and repeat the other direction.",
            duration = 30,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kali Squat Sideways Half Bound 1",
            displayResId = R.drawable.kali_squat_sideways_half_bound_1,
            description = "In a wide squat, bind one arm behind your back to hold your opposite hip. Rest the other arm on your knee and look upward.",
            duration = 30,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kali Squat Sideways Half Bound 2",
            displayResId = R.drawable.kali_squat_sideways_half_bound_2,
            description = "From a deep squat, bind one arm behind to hold your hip and rest the opposite wrist on your knee. Lift your gaze upward and hold.",
            duration = 30,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kali Squat Sideways Half Bound 3",
            displayResId = R.drawable.kali_squat_sideways_half_bound_3,
            description = "Rise to tiptoes in a deep squat. Cross your arms at the elbows and place palms on the floor, fingers facing inward. Hold and breathe.",
            duration = 15,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kick Back with Band",
            displayResId = R.drawable.kick_back_with_band_or_towel,
            description = "Lie on your back with one knee pulled toward your chest and the other leg extended. Loop a band around the bent foot and kick it upward, then return to the starting position. Repeat for time.",
            duration = 30,
            muscleGroups = listOf("Upper Back")
        ),
        Exercise(
            name = "Knee Across Body",
            displayResId = R.drawable.knee_across_body,
            description = "Lie on your back with arms outstretched. Bend one knee and cross it over the opposite side using your hand to guide the stretch. Hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Glutes")
        ),
        Exercise(
            name = "Knee Bend Side Lying",
            displayResId = R.drawable.knee_bend_side_lying,
            description = "Lie on one side with the top leg bent and the foot pulled toward the hips using the hand. Keep the head rested on the extended arm and hold the stretch.",
            duration = 20,
            muscleGroups = listOf("Quadriceps")
        ),
        Exercise(
            name = "Knee Extensors Kneeling",
            displayResId = R.drawable.knee_extensor_kneeling_advanced,
            description = "From a kneeling position, bring one leg forward at 90 degrees. Gently press hips forward while keeping the back leg straight to stretch the hip flexors and extensors.",
            duration = 20,
            muscleGroups = listOf("Quadriceps")
        ),
        Exercise(
            name = "Knee Flex Seated",
            displayResId = R.drawable.knee_flexor_seated_advanced,
            description = "Sit with legs extended. Bend at the waist and reach hands down along the legs to deepen the hamstring stretch. Hold while maintaining posture.",
            duration = 20,
            muscleGroups = listOf("Hamstrings")
        ),
        Exercise(
            name = "Knee Flexor Standing",
            displayResId = R.drawable.knee_flexor_standing,
            description = "Stand and step one foot forward into a stretch. Fold your torso over the front leg and reach toward the ground, keeping both legs straight. Switch sides after holding.",
            duration = 15,
            muscleGroups = listOf("Hamstrings")
        ),
        Exercise(
            name = "Knee to Chest",
            displayResId = R.drawable.knee_to_chest,
            description = "Lie on your back and bring one knee toward your chest. Use your hands to gently pull the knee closer for a deeper stretch. Switch legs after holding.",
            duration = 20,
            muscleGroups = listOf("Lower Back")
        ),
        Exercise(
            name = "Kneeling Half Split",
            displayResId = R.drawable.kneeling_half_split,
            description = "Begin kneeling on the floor. Extend one leg in front and grab the toes with the same-side hand. Lift the leg overhead while keeping your gaze upward. Hold, then switch sides.",
            duration = 20,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kneeling Half Split Side Plank",
            displayResId = R.drawable.kneeling_half_split_side_plank_modification,
            description = "From a kneeling position, place one hand on the floor and lean into a side plank. Grab the top leg’s toes with the same-side hand and lift the leg to the side. Hold, then switch sides.",
            duration = 20,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kneeling Half Split Plank Modification",
            displayResId = R.drawable.kneeling_half_split_to_side_plank_modification,
            description = "Start kneeling and extend one leg out to the side. Reach for the toes with the same-side hand and lift the leg above your head. Gaze upward. Hold, then repeat on the other side.",
            duration = 20,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Kneeling Reach",
            displayResId = R.drawable.kneeling_reach,
            description = "Kneel at arm’s length from a chair. Rest both forearms on the seat and fold forward until your back is parallel to the floor. Let your head and shoulders relax downward. Hold.",
            duration = 30,
            muscleGroups = listOf("Upper Back")
        ),
        Exercise(
            name = "Kneeling Reach Around",
            displayResId = R.drawable.kneeling_reach_around,
            description = "Start on all fours and reach back to grab your ankle with the same-side hand. Hold the position, feeling the twist in the torso. Switch sides after holding.",
            duration = 15,
            muscleGroups = listOf("Obliques")
        ),
        Exercise(
            name = "Kneeling with Band Shoulder and Hip",
            displayResId = R.drawable.kneeling_with_band_shoulder_and_hip_stretch,
            description = "Kneel with a resistance band under one leg. Extend the other leg forward. Hold the band behind your back and lift your arms to stretch the shoulders and arms. Hold and repeat.",
            duration = 10,
            muscleGroups = listOf("Triceps", "Biceps")
        ),
        Exercise(
            name = "Knees Bent Shoulder and Back Adductor",
            displayResId = R.drawable.knees_bent_shoulder_and_back_adductor,
            description = "Bend your knees into a squat while keeping them together. Reach your arms down with palms pressed and keep your back parallel to the floor as you pull your arms away from your shoulders. Hold the stretch.",
            duration = 20,
            muscleGroups = listOf("Upper Back")
        ),

        Exercise(
            name = "Knees to Chest",
            displayResId = R.drawable.knees_to_chest,
            description = "Lie on your back with knees bent. Gently pull both knees toward your chest, holding behind your thighs or shins. Keep your lower back pressed to the floor and hold.",
            duration = 20,
            muscleGroups = listOf("Lower Back")
        ),

        Exercise(
            name = "Lat and Upper Back in Child's Pose",
            displayResId = R.drawable.lat_and_upper_back_stretch_in_child_s_pose,
            description = "Kneel down and extend one arm forward. Drop the opposite shoulder to the floor, twisting your torso and reaching that arm outward. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Latissimus Dorsi")
        ),

        Exercise(
            name = "Lat Stretch Trunk Rotation",
            displayResId = R.drawable.lat_stretch_with_trunk_rotation,
            description = "Kneel with forearms resting on an exercise ball and head on your hands. Roll the ball to one side, gently twisting your torso. Hold, then switch sides.",
            duration = 15,
            muscleGroups = listOf("Latissimus Dorsi")
        ),

        Exercise(
            name = "Lateral Leg Raise 1",
            displayResId = R.drawable.lateral_leg_raise_1,
            description = "Lie flat with legs straight. Bring one knee into your chest and place your hands under the calf. Straighten the leg gently and pull toward your torso. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Glutes")
        ),

        Exercise(
            name = "Lateral Leg Raise 2",
            displayResId = R.drawable.lateral_leg_raise_2,
            description = "Lie flat with legs extended. Pull one knee into your chest and place hands beneath the thigh. Gently bring the leg closer to your body. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Glutes")
        ),

        Exercise(
            name = "Lateral Leg Raise 3",
            displayResId = R.drawable.lateral_leg_raise_3,
            description = "Lie flat and bring one knee into your chest. Hold your foot with both hands, gently straighten the leg, and draw it toward your torso. Hold before switching sides.",
            duration = 15,
            muscleGroups = listOf("Glutes")
        ),

        Exercise(
            name = "Lateral Wall Stretch",
            displayResId = R.drawable.lateral_wall_stretch,
            description = "Stand facing away from a wall at arm’s length. Twist your torso to one side and press both palms into the wall. Hold and repeat on the opposite side.",
            duration = 15,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Leg Cradle",
            displayResId = R.drawable.leg_cradle,
            description = "Seated with legs extended, bend one knee and place the foot on the opposite thigh. Wrap your elbow and hand around the shin and foot, pulling the leg up toward your shoulder. Hold, then switch legs.",
            duration = 10,
            muscleGroups = listOf("Abductors")
        ),
        Exercise(
            name = "Leg Extended Crunch",
            displayResId = R.drawable.leg_extended_crunch,
            description = "Lie on your back with legs raised. Place your hands behind your head and lift your upper back toward your knees. Lower down while keeping your head and shoulders elevated. Repeat until time is up.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),

        Exercise(
            name = "Leg Extended with Band",
            displayResId = R.drawable.leg_extended_with_band_or_towel,
            description = "Sit upright with legs extended and a resistance band behind your feet. Pull the band toward your chest and lean back, balancing on your pelvis. Hold the position.",
            duration = 15,
            muscleGroups = listOf("Abdominals")
        ),

        Exercise(
            name = "Side-Lying Leg & Ab Stretch",
            displayResId = R.drawable.leg_extension_and_ab_stretch_side_lying,
            description = "Lie on your back with knees bent. Pull one knee into your chest while lifting your shoulders off the floor and extending the opposite leg. Hold, then switch sides.",
            duration = 20,
            muscleGroups = listOf("Glutes")
        ),

        Exercise(
            name = "Leg Hinge Double",
            displayResId = R.drawable.leg_hinge_double,
            description = "Stand a few paces from a chair and lean forward to grip the backrest. Let your head and shoulders relax toward the floor and hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Upper Back")
        ),

        Exercise(
            name = "Leg Lift Side",
            displayResId = R.drawable.leg_lift_side,
            description = "Lie on your side with one hand supporting your head. Keeping your legs straight and toes pointed, lift and lower your top leg in a controlled motion.",
            duration = 30,
            muscleGroups = listOf("Abductors")
        ),

        Exercise(
            name = "Leg Lifts",
            displayResId = R.drawable.leg_lifts,
            description = "Lie flat with knees bent. Extend one leg at a 45-degree angle, then lift your upper body and twist toward the extended leg. Lower down and alternate sides.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),

        Exercise(
            name = "Leg Raise Pointed Toe",
            displayResId = R.drawable.leg_paise_pointed_toe,
            description = "Stand tall with hands on hips. Keeping your legs straight, lift one leg forward until parallel to the floor. Hold briefly, then lower. Repeat on each side.",
            duration = 30,
            muscleGroups = listOf("Glutes")
        ),
        Exercise(
            name = "Leg Raise Reach",
            displayResId = R.drawable.leg_raise_reach,
            description = "Stand tall with hands on your lower back. Swing one leg straight out in front of you just above hip level. Hold briefly, then return to standing. Repeat on each side.",
            duration = 30,
            muscleGroups = listOf("Glutes")
        ),

        Exercise(
            name = "Leg Raise Superman",
            displayResId = R.drawable.leg_raise_superman,
            description = "Lie on your stomach with arms extended overhead. Simultaneously lift your left arm and right leg, keeping both straight. Hold briefly, then alternate sides.",
            duration = 30,
            muscleGroups = listOf("Back")
        ),

        Exercise(
            name = "Leg Rotation Leaning on Ball",
            displayResId = R.drawable.leg_rotation_leaning_on_ball,
            description = "Stand a few steps from an exercise ball and lean onto it with one forearm. Extend your opposite leg behind you while pointing your free arm downward. Hold, then switch sides.",
            duration = 15,
            muscleGroups = listOf("Abdominals")
        ),

        Exercise(
            name = "Lotus Pose Arms Extended",
            displayResId = R.drawable.lotus_pose_arms_extended,
            description = "Sit in lotus pose with your spine tall. Lace your fingers and stretch your arms overhead with palms facing up. Gaze toward the ceiling and hold.",
            duration = 30,
            muscleGroups = listOf("Upper Back")
        ),

        Exercise(
            name = "Lotus Pose Reaching Back",
            displayResId = R.drawable.lotus_pose_reaching_back,
            description = "Sit in lotus pose with a straight spine. Place your palms on the floor behind you and draw your shoulders back as you look upward. Hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Upper Back")
        ),
        Exercise(
            name = "Lower Back Standing",
            displayResId = R.drawable.lower_back_standing,
            description = "Stand tall with your hands pressed into your lower back. Gently push your hips forward into a backbend and hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Lower Back")
        ),

        Exercise(
            name = "Lower Trunk Flexor Standing",
            displayResId = R.drawable.lower_trunk_flexor_standing,
            description = "Stand with knees slightly bent. Drop your head back and pull your shoulders into a backbend, lifting your chin toward the ceiling.",
            duration = 30,
            muscleGroups = listOf("Chest")
        ),

        Exercise(
            name = "Supported Lateral Trunk Stretch",
            displayResId = R.drawable.lower_trunk_lateral_flexor_supported,
            description = "Lean one hand against a wall and shift your feet to the side. Use your other hand to press into your hips, deepening the lateral stretch.",
            duration = 30,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Lumbar Stretch Sitting with Ball",
            displayResId = R.drawable.lumbar_stretch_sitting_with_ball,
            description = "Sit on a chair and roll forward onto an exercise ball until your elbows rest on it. Relax into the stretch and hold.",
            duration = 15,
            muscleGroups = listOf("Lower Back")
        ),

        Exercise(
            name = "Lunge to Side",
            displayResId = R.drawable.lunge_to_side,
            description = "Stand wide with toes pointed out. Lunge to one side, resting your elbow on your knee, and stretch your opposite arm overhead. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Lunge to the Side",
            displayResId = R.drawable.lunge_to_the_side,
            description = "Step into a wide stance. Lunge to one side and drop your hand beside your foot. Reach your opposite arm overhead for a deep side stretch.",
            duration = 15,
            muscleGroups = listOf("Obliques")
        ),
        Exercise(
            name = "Lunge with Side Bend",
            displayResId = R.drawable.lunge_with_side_bend,
            description = "Stand with arms arched overhead. Step one foot forward into a lunge and lean your torso toward the front leg. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Lunge Prayer Stretch",
            displayResId = R.drawable.lunging_forward_stretch_prayer_hands,
            description = "With hands together overhead in prayer position, step forward into a deep lunge. Keep your arms extended and alternate sides for the full duration.",
            duration = 30,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Lunging Forward Twist",
            displayResId = R.drawable.lunging_forward_twist,
            description = "Step into a deep lunge. Twist toward the front leg and place your opposite hand on the floor. Extend your other arm forward and look up. Switch sides.",
            duration = 30,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Lying Down Arm Extension",
            displayResId = R.drawable.lying_down_arm_extension,
            description = "Kneel with your hips on your heels. Drop one hand to the floor and raise the other arm overhead. Stretch through the lifted shoulder and switch sides.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Lying Down Arm Stretch",
            displayResId = R.drawable.lying_down_arm_stretch,
            description = "Lie flat on your back with legs extended. Reach both arms overhead and press them to the floor, stretching along the length of your body.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Lying Down Figure 4",
            displayResId = R.drawable.lying_down_figure_4,
            description = "Lie on your back with one leg bent and the opposite ankle resting on the thigh. Gently pull the bent knee down to deepen the stretch. Switch sides after holding.",
            duration = 30,
            muscleGroups = listOf("Abductors")
        ),

        Exercise(
            name = "Lying Scissor Arms",
            displayResId = R.drawable.lying_scissor_arms,
            description = "Lie on your back with knees bent. Extend one arm overhead and the other at your side. Alternate arm positions in a controlled motion for the duration.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Mermaid Pose 1",
            displayResId = R.drawable.mermaid_pose_1,
            description = "Sit with knees bent and feet to one side. Hold your ankles with one hand and lift the opposite arm overhead, reaching upward to stretch the side body.",
            duration = 20,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Mermaid Pose 2",
            displayResId = R.drawable.mermaid_pose_2,
            description = "Sit with knees bent and feet tucked to the side. Raise one arm overhead and stretch it sideways across your body to deepen the side bend.",
            duration = 20,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Bound Hands Mountain Pose",
            displayResId = R.drawable.mountain_pose_with_bound_hands,
            description = "Stand tall and clasp your hands behind your back. Raise your arms upward while keeping your back straight. Hold and release gently.",
            duration = 15,
            muscleGroups = listOf("Upper back")
        ),

        Exercise(
            name = "Mountain Shoulder Opener",
            displayResId = R.drawable.mountain_pose_with_shoulder_opener,
            description = "Stand upright and bend one arm behind your head. Use the other hand to gently pull the elbow. Slightly bend the spine for a deeper stretch.",
            duration = 30,
            muscleGroups = listOf("Latissimus dorsi")
        ),
        Exercise(
            name = "Neck Flexor and Rotation",
            displayResId = R.drawable.neck_flexor_and_rotationa,
            description = "Sit or stand tall. Use one hand to gently pull your head sideways, stretching the neck. Hold and repeat on the other side.",
            duration = 20,
            muscleGroups = listOf("Neck")
        ),

        Exercise(
            name = "Neck Hyperextension",
            displayResId = R.drawable.neck_hyperextension,
            description = "Maintain upright posture and gently push your chin forward, extending the neck. Hold the stretch and release slowly.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),

        Exercise(
            name = "Noose Pose",
            displayResId = R.drawable.noose_pose,
            description = "Squat low with feet together. Twist to one side, hooking the opposite elbow to the outside of the knee. Reach the opposite arm overhead and hold.",
            duration = 10,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Noose Pose Half Bound",
            displayResId = R.drawable.noose_pose_half_bound,
            description = "In a deep squat, twist your torso and place one hand to the floor. Wrap the other arm around your back for a bound stretch. Switch sides after holding.",
            duration = 15,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Noose Pose Deep Squat",
            displayResId = R.drawable.nose_pose_deep_squat,
            description = "Squat deeply with feet together. Twist and hook your elbow to the outside of the knee, reaching the opposite arm overhead. Alternate sides.",
            duration = 10,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Single Arm Back Reach",
            displayResId = R.drawable.one_arm_upper_back_reaching,
            description = "Crouch near a door frame and reach one arm forward to grab it. Pull your body back to stretch through the upper back. Switch arms after holding.",
            duration = 20,
            muscleGroups = listOf("Upper back")
        ),

        Exercise(
            name = "One Hand Side Stretch",
            displayResId = R.drawable.one_hand_side_stretch,
            description = "Sit with one knee bent and the opposite leg extended. Reach both arms overhead and stretch toward the side of the extended leg.",
            duration = 20,
            muscleGroups = listOf("Obliques")
        ),
        Exercise(
            name = "Bound One-Leg Balance",
            displayResId = R.drawable.one_leg_bound_standing_balance_variation,
            description = "From a standing position, lift one knee and twist your torso to bind your arms around the raised leg. Slowly bend the supporting leg and rest the foot on the opposite knee. Hold and switch sides.",
            duration = 20,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "One-Leg Backbend Balance",
            displayResId = R.drawable.one_leg_standing_balance_intense_backbend,
            description = "Lift one foot and grab it behind your body with the same-side hand. Extend the opposite arm overhead and gently lean back into a deep backbend. Hold and switch sides.",
            duration = 20,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "One Legged Butterfly",
            displayResId = R.drawable.one_legged_butterfly,
            description = "While seated, bring one foot toward your groin, resting the ankle on the opposite thigh. Gently pull the bent leg toward your torso to deepen the stretch.",
            duration = 20,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Overhead Bicep Stretch",
            displayResId = R.drawable.overhead_bicep_stretch,
            description = "Bend one elbow and rest the hand on your back. Use the opposite hand to press down on the elbow, stretching the triceps and shoulder.",
            duration = 20,
            muscleGroups = listOf("Triceps and biceps")
        ),

        Exercise(
            name = "Overhead Shoulder Stand",
            displayResId = R.drawable.overhead_modification_shoulder_stand,
            description = "Lie on your back, raise your legs and hips into a shoulder stand. Bend at the hips and lower your toes behind you while keeping legs and back straight. Hold the pose.",
            duration = 20,
            muscleGroups = listOf("Headstand and handstand")
        ),

        Exercise(
            name = "Overhead Reach Seated",
            displayResId = R.drawable.overhead_reach_seated,
            description = "Sit on an exercise ball with legs wide. Raise one arm overhead and lean the torso sideways to stretch along the opposite side. Hold and alternate sides.",
            duration = 15,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Overhead Stretch",
            displayResId = R.drawable.overhead_stretch,
            description = "Sit upright and lace your fingers together. Raise your arms overhead, turning palms upward. Stretch tall through the shoulders and arms while maintaining good posture.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Palm Down Wrist Stretch",
            displayResId = R.drawable.palm_down_arm_straight_wrist_stretch,
            description = "Extend one arm forward with the palm facing out and fingers pointing down. Use the opposite hand to gently pull the fingers toward you. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Wrists")
        ),

        Exercise(
            name = "Palm Down Wrist Stretch",
            displayResId = R.drawable.palm_down_wrist_stretch,
            description = "Bring one wrist toward your chest, palm facing out. Use the opposite hand to press down on the fingers for a wrist stretch. Hold and switch arms.",
            duration = 15,
            muscleGroups = listOf("Wrists")
        ),

        Exercise(
            name = "Palm Up Wrist Stretch",
            displayResId = R.drawable.palm_wup_wrist_stretch,
            description = "Raise one arm straight ahead, palm up and fingers pointing toward the ceiling. Use the opposite hand to pull the fingers back gently. Hold and repeat on the other side.",
            duration = 15,
            muscleGroups = listOf("Wrists")
        ),

        Exercise(
            name = "Peck to Back on Ball",
            displayResId = R.drawable.peck_to_back_on_ball_or_chair,
            description = "Kneel beside an exercise ball and place one bent arm on top of it. Roll the ball side to side to activate muscles beneath the shoulder. Hold and switch sides.",
            duration = 30,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Plank Forearm",
            displayResId = R.drawable.plank_forearm,
            description = "Start on all fours and lower onto your forearms. Step your feet back into a plank position, forming a straight line from head to heels. Hold the pose.",
            duration = 20,
            muscleGroups = listOf("Abdominals")
        ),

        Exercise(
            name = "Prayer Hands",
            displayResId = R.drawable.prayer_hands,
            description = "Press your palms together in front of your chest with fingers pointing upward. Hold the stretch while maintaining good posture.",
            duration = 30,
            muscleGroups = listOf("Forearms")
        ),

        Exercise(
            name = "Prone Hamstring & Glute Pull",
            displayResId = R.drawable.prone_hamstring_and_glute_pull,
            description = "Lie flat on your back and bend one knee. Hook your hands under the thigh and gently pull the knee toward your chest. Hold and alternate legs.",
            duration = 10,
            muscleGroups = listOf("Hamstrings")
        ),

        Exercise(
            name = "Prone Hip External Rotation",
            displayResId = R.drawable.prone_hip_external_rotation,
            description = "Lie on your back with knees bent. Lift one leg and press the knee toward your chest using the same-side hand. Hold the stretch and switch legs.",
            duration = 20,
            muscleGroups = listOf("Abductors")
        ),
        Exercise(
            name = "Prone Hip External Rotation 1",
            displayResId = R.drawable.prone_hip_external_rotation_1,
            description = "Lie on your stomach with knees bent and feet flexed. Move your ankles away from each other while keeping knees on the floor. Bring feet back together and repeat.",
            duration = 20,
            muscleGroups = listOf("Abductors")
        ),

        Exercise(
            name = "Quad Stretch Cross-Legged",
            displayResId = R.drawable.quad_strech_cross_legged,
            description = "Sit cross-legged with one foot pulled into the opposite hip. Place palms on the floor under your hips and gently lean forward to stretch. Hold and switch legs.",
            duration = 15,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Quad Stretch Bilateral",
            displayResId = R.drawable.quad_stretch_bilateral,
            description = "Kneel with hips resting on heels. Place hands behind you and straighten your arms to lift your hips, forming a line from knees to shoulders. Hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Quad Stretch Bilateral Prep",
            displayResId = R.drawable.quad_stretch_bilateral_prep,
            description = "Kneel on the floor with hips resting on heels. Place hands at your sides and gaze forward. Maintain an upright posture and hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Quad Stretch Lying",
            displayResId = R.drawable.quad_stretch_lying,
            description = "Lie on your stomach and bend one leg to bring the foot toward your hips. Reach back with the same-side hand to gently pull the foot for a quad stretch.",
            duration = 20,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Quad Stretch Standing",
            displayResId = R.drawable.quad_stretch_standing,
            description = "Stand and shift weight to one leg. Bend the opposite knee and grab the foot behind you. Pull gently toward your hips. Hold and alternate sides.",
            duration = 20,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Quadriceps Hip Twist",
            displayResId = R.drawable.quadriceps_hip_twist,
            description = "Kneel and step one foot far forward into a deep lunge. Lift the back foot onto tiptoes and lower your hips. Lean forward, placing palms on the floor. Hold.",
            duration = 15,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Rabbit Pose Shoulder",
            displayResId = R.drawable.rabbit_pose_shoulder_sretch,
            description = "Start on all fours, then lower your head toward your knees. Clasp your hands behind your back and raise them upward as you balance on the crown of your head.",
            duration = 20,
            muscleGroups = listOf("Upper Back", "Shoulders")
        ),
        Exercise(
            name = "Reach and Kick Back",
            displayResId = R.drawable.reach_and_kick_back,
            description = "Start on all fours. Extend your left leg behind you at hip height while simultaneously raising your right arm to shoulder height. Alternate sides for the duration.",
            duration = 30,
            muscleGroups = listOf("Glutes")
        ),

        Exercise(
            name = "Reaching Lat Stretch",
            displayResId = R.drawable.reaching_lat_stretch,
            description = "Stand facing a wall and lean your left hand against it. Reach your right arm overhead until both hands align. Push your hips out to the right to intensify the stretch.",
            duration = 30,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Rear Arm with Band",
            displayResId = R.drawable.rear_arm_stretch_with_band,
            description = "Hold a resistance band behind your back with palms facing upward. Straighten your arms and pull your hands away from each other against resistance. Hold the stretch and repeat.",
            duration = 10,
            muscleGroups = listOf("Triceps and biceps")
        ),

        Exercise(
            name = "Rear Arm with Band 2",
            displayResId = R.drawable.rear_arm_stretch_with_band2,
            description = "Hold a body bar vertically at your side with your right hand. Reach over with your left hand to grab the top and lift the bar upward. Hold briefly and switch sides.",
            duration = 5,
            muscleGroups = listOf("Triceps and biceps")
        ),

        Exercise(
            name = "Reverse Lunge Twist Reach",
            displayResId = R.drawable.reverse_lunge_with_twist_and_overhead_reach,
            description = "Step into a lunge with your right foot forward. Twist your torso to the right while extending your arms overhead. Hold and alternate sides.",
            duration = 10,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Uneven Leg Reverse Prayer Pose",
            displayResId = R.drawable.reverse_prayer_revolved_uneven_legs_half_intense_stretch,
            description = "Stand with palms in reverse prayer behind your back. Raise one leg onto tiptoes, then bend forward while twisting. Keep your back parallel to the floor and hold.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Revolved Angle Pose Advanced",
            displayResId = R.drawable.revolved_angle_pose_advanced,
            description = "Lunge deeply with your left foot forward and fingertips on the floor. Lift your left arm straight up and rotate through your torso. Hold and repeat on the other side.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),
        Exercise(
            name = "Revolved Feet Spread Out Intense",
            displayResId = R.drawable.revolved_feet_spread_out_intense_stretch,
            description = "Stand with your legs wide and torso bent parallel to the floor. Reach your right hand to your left ankle while twisting your torso to the left. Reach your left arm behind your back and gaze upward.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Revolved Paying-Homage Feet Spread",
            displayResId = R.drawable.revolved_feet_spread_out_intense_stretch_1,
            description = "Step your left foot behind and across the other. Fold forward at the waist along your right leg, and reach around your leg to hold your heel. Hold, then switch legs.",
            duration = 20,
            muscleGroups = listOf("Abductors")
        ),

        Exercise(
            name = "Revolved Plank",
            displayResId = R.drawable.revolved_plank,
            description = "Sit with knees bent and palms behind you. Lift your hips from the floor and step your legs out straight. Let your head drop back to open your chest and neck. Hold the position.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Revolved Staff Pose One Leg Upward",
            displayResId = R.drawable.revolved_staff_pose_one_leg_upward,
            description = "Sit with legs extended. Twist to your right and place both hands to your right. Raise your right leg and hold the ankle with your left hand. Gently pull upward and hold.",
            duration = 20,
            muscleGroups = listOf("Abductors")
        ),

        Exercise(
            name = "Staff Twist with One Arm Reach",
            displayResId = R.drawable.revolved_staff_pose_upward_one_arm_extended_hand_to_foot,
            description = "Seated with legs straight, twist to the right and hold your right foot with your left hand. Extend your right arm behind you and look upward to open the chest.",
            duration = 20,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Revolved Triangle",
            displayResId = R.drawable.revolved_triangle,
            description = "Stand and cross your left foot behind your right. Bend at the hips and twist your torso to the right, placing your left hand on your right foot and raising your right arm upward.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),
        Exercise(
            name = "Wrist Rotations",
            displayResId = R.drawable.rist_rotations,
            description = "Clasp your fingers and press your palms together in front of your chest. Rotate your wrists slowly in a circular motion, clockwise then counterclockwise. Continue for thirty seconds.",
            duration = 30,
            muscleGroups = listOf("Wrists")
        ),

        Exercise(
            name = "Hip Opener – Foot Raised",
            displayResId = R.drawable.rotational_hip_opener_foot_raised,
            description = "Stand beside a sturdy chair and rest your raised foot behind you on the back of the chair. Slowly lower your pelvis to deepen the stretch. Hold and switch legs.",
            duration = 15,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Hip Opener – Leg Raised",
            displayResId = R.drawable.rotational_hip_opener_leg_raised,
            description = "Stand upright and raise your bent knee behind you onto the back of a chair. Gently lower your pelvis to intensify the stretch. Hold and repeat on the other leg.",
            duration = 15,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Rotational Thighs",
            displayResId = R.drawable.rotational_thighs,
            description = "Sit on the floor with one leg curled behind and the other folded in. Place your hands behind you and lean your torso back to open the chest. Hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Abductors")
        ),

        Exercise(
            name = "Scoop Rhomboids",
            displayResId = R.drawable.scoop_rhomboids,
            description = "Sit with feet flat and knees bent. Hold your thighs and round your upper back, leaning back onto your hips while tucking your chin to your chest. Hold and return to start.",
            duration = 20,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Seated Forward Lean",
            displayResId = R.drawable.seated_forward_lean,
            description = "Sit on an exercise ball with your feet apart. Rest your elbows on your knees and lean your head down toward the floor. Breathe deeply and hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Lower back")
        ),

        Exercise(
            name = "Arm Extension",
            displayResId = R.drawable.seated_large_arm_circles,
            description = "Kneel with your hips on your heels. Drop one hand to the floor and extend the opposite arm upward. Pull your shoulder away from your chest and hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Seated Spinal Stretch",
            displayResId = R.drawable.seated_spinal_stretch,
            description = "Sit cross-legged and twist your spine to one side. Bring the opposite hand to your knee and the other behind you on the floor. Look back and hold the stretch.",
            duration = 15,
            muscleGroups = listOf("Spine")
        ),
        Exercise(
            name = "Self Knee Stretch",
            displayResId = R.drawable.self_knee_stretch,
            description = "Lie on your back with both knees bent. Rest one ankle on the opposite knee and use your hands to pull the supporting leg toward your chest. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Hamstrings")
        ),

        Exercise(
            name = "Shoulder Mobility Flow",
            displayResId = R.drawable.shoulder_abductor_protractor_and_elevator,
            description = "Reach one arm across your chest and use the opposite hand to gently press it closer. Feel the stretch through your shoulder and hold before switching arms.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder Abductor to Wall",
            displayResId = R.drawable.shoulder_abductor_to_wall,
            description = "Stand beside a wall and raise the arm closest to it, pressing your palm above your head. Lean your torso into the wall to deepen the stretch. Hold and switch sides.",
            duration = 20,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder Adductor Stretch",
            displayResId = R.drawable.shoulder_adductor_and_extensor_stretch,
            description = "Crouch low facing a vertical surface and reach one arm up to grab it above eye level. Lean your body backward to stretch the shoulder. Switch arms after holding.",
            duration = 20,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Supported Shoulder Adductor",
            displayResId = R.drawable.shoulder_adductor_and_extensor_stretch_supported_,
            description = "Face a sturdy vertical surface and bend both knees. Reach one arm to grab the surface at eye level and lean back to stretch the shoulder. Alternate sides after holding.",
            duration = 20,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder and Back Curl Seated",
            displayResId = R.drawable.shoulder_and_back_curl_seated,
            description = "Sit with legs extended and hands beside your knees. Drop your head to your chest and curl your shoulders forward, rounding the upper back. Hold the stretch.",
            duration = 20,
            muscleGroups = listOf("Upper back")
        ),

        Exercise(
            name = "Shoulder Blade Pinch",
            displayResId = R.drawable.shoulder_blade_pinch,
            description = "Sit or stand tall and place your hands behind your head. Pinch your shoulder blades tightly together and hold, then release briefly before repeating.",
            duration = 10,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Shoulder Bridge",
            displayResId = R.drawable.shoulder_bridge,
            description = "Lie on your back with your knees bent and arms at your sides. Press your feet into the floor and lift your hips upward, keeping your shoulders grounded. Hold and release.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),

        Exercise(
            name = "Shoulder Bridge Bound",
            displayResId = R.drawable.shoulder_bridge_bound,
            description = "Lie flat with knees bent and arms at your sides. Lift your hips and reach your hands to your ankles, pushing your hips higher while holding the stretch.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Shoulder Bridge Bound Prep",
            displayResId = R.drawable.shoulder_bridge_bound_prep,
            description = "Lie on your back with arms at your sides and knees bent. Step your feet in toward your hips, preparing for bridge variations.",
            duration = 10,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Banded Shoulder Bridge Press",
            displayResId = R.drawable.shoulder_bridge_pelvic_press_with_band,
            description = "Lie on your back with knees bent. Place palms beside your head and lift your body into a rounded back bridge, letting your head and shoulders drop. Hold confidently.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Triple Shoulder Opener",
            displayResId = R.drawable.shoulder_extensor_abductor_and_retractor,
            description = "Stand with your left side to a wall. Reach your right hand across your chest and press it against the wall. Push your hips away to deepen the stretch. Hold, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Triple Shoulder Opener (Turned)",
            displayResId = R.drawable.shoulder_extensor_abductor_and_retractor_body_turned,
            description = "Sit on a chair with feet flat. Twist your torso to one side and bend forward, placing your hands on the ground. Hold and repeat on the other side.",
            duration = 15,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Shoulder Flexor",
            displayResId = R.drawable.shoulder_flexor,
            description = "Stand tall and extend both arms behind you, raising them up your back. Pull your arms inward to engage and stretch the shoulder muscles. Hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Supported Shoulder Flexor & Depressor",
            displayResId = R.drawable.shoulder_flexor_and_depressor_stretch_supported,
            description = "Stand in the corner of a room facing outward. Raise both arms overhead and place your palms on the walls. Push your chest out while keeping your palms pressed. Hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder Hyperextension 2",
            displayResId = R.drawable.shoulder_hyperextension_2,
            description = "Stand or sit upright. Place the backs of your wrists against your waist with bent elbows. Pull your elbows forward and toward each other. Hold the stretch and release.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder Reach Behind Back",
            displayResId = R.drawable.shoulder_reach_behind_back,
            description = "Stand upright with fingers clasped behind your back and raised toward the middle spine. Extend arms downward with palms facing the floor and pull shoulders back. Hold and repeat.",
            duration = 10,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder Stand",
            displayResId = R.drawable.shoulder_stand,
            description = "Lie faceup with knees bent. Raise legs into the air above your hips and place hands on your lower back for support. Lift hips upward into a shoulder stand and hold.",
            duration = 20,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder Stretch",
            displayResId = R.drawable.shoulder_stretch,
            description = "Reach your arm across your body and use the opposite hand to gently press your elbow toward your chest. Hold this stretch and switch sides.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Wall Shoulder Stretch",
            displayResId = R.drawable.shoulder_stretch_against_the_wall,
            description = "Stand next to a wall with one elbow bent overhead and hand on your upper back. Press your raised elbow into the wall to deepen the stretch. Hold and switch arms.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Body Bar Shoulder Twist",
            displayResId = R.drawable.shoulder_stretch_body_bar_twist,
            description = "Hold a body bar vertically with one hand straight in front of you. Rotate your hand to move the bar parallel to the ground, then return to the start. Repeat on each arm.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Shoulder Stretch Cross Over",
            displayResId = R.drawable.shoulder_stretch_cross_over,
            description = "Crouch down with your hands on opposite knees. Curl your head and shoulders toward the floor and hold. Then pull your shoulders back and raise your gaze upward. Hold again.",
            duration = 60,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Shoulder Stretch Crouching",
            displayResId = R.drawable.shoulder_stretch_crouching,
            description = "Stand and clasp your hands behind your back. Bend your knees and lean forward, letting your torso rest against your thighs. Raise your clasped hands behind you and hold.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Elbow Hold Shoulder Stretch",
            displayResId = R.drawable.shoulder_stretch_hands_to_elbows,
            description = "Sit cross-legged and reach both hands behind your back, clasping the opposite elbows. Pull your elbows down gently to open your shoulders and chest. Hold the stretch.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Kneeling Arms Extended Stretch",
            displayResId = R.drawable.shoulder_stretch_kneeling_arms_extended,
            description = "Begin on all fours and step both hands forward. Lean your hips back onto your heels while pulling gently through your arms and shoulders. Hold this stretch.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Seated Overhead Reach",
            displayResId = R.drawable.shoulder_stretch_overhead_reach_to_floor_seated,
            description = "Sit on a chair and bend forward, lowering your torso to your thighs and placing your hands on the floor between your feet. Hold the position.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Seated Overhead Side Reach",
            displayResId = R.drawable.shoulder_stretch_overhead_side_reach_to_floor_seated,
            description = "Sit on a chair with feet flat. Twist your torso to one side and bend forward, placing your hands on the floor. Hold the stretch and alternate sides.",
            duration = 15,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Shoulder Stretch Reverse Supported",
            displayResId = R.drawable.shoulder_stretch_reverse_supported,
            description = "Stand with your back to a sturdy chair and reach back to grab the top. Squat down to straighten your arms parallel to the floor and hold the stretch.",
            duration = 15,
            muscleGroups = listOf("Shoulders")
        ),
        Exercise(
            name = "Shoulder Traction",
            displayResId = R.drawable.shoulder_traction,
            description = "Stand next to a door frame and reach your arm across your chest to grab the frame. Gently pull to stretch your shoulder. Hold and repeat on the opposite side.",
            duration = 30,
            muscleGroups = listOf("Shoulders")
        ),

        Exercise(
            name = "Wall Sickle Stretch",
            displayResId = R.drawable.sickle_stretch_standing_wall_supported,
            description = "Stand beside a wall for support and curl one foot inward, resting on the outer toes. Gently press into the curled toes to deepen the stretch. Switch sides.",
            duration = 30,
            muscleGroups = listOf("Feet")
        ),

        Exercise(
            name = "Side Assisted Neck Tilt",
            displayResId = R.drawable.side_assisted_neck_tilt,
            description = "While standing or sitting, use your hand to gently pull your head to one side, stretching the neck. Hold and switch directions.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),

        Exercise(
            name = "Side Bending Mountain Pose",
            displayResId = R.drawable.side_bending_mountain_pose,
            description = "Stand tall with hands clasped overhead. Bend your arms and torso backward and to one side, opening the chest and stretching the obliques. Repeat on both sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Plank Chest Opener",
            displayResId = R.drawable.side_plank_chest_opener,
            description = "Lie on your side and lift your hips and torso. Stack your feet and raise your top hand toward the ceiling. Hold the position and switch sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Plank Easier Modification",
            displayResId = R.drawable.side_plank_easier_modification,
            description = "Lie on your side with the top foot forward. Push into a side plank and lift the top leg and arm. Attempt to reach your foot with your hand and hold.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Plank Easy",
            displayResId = R.drawable.side_plank_easy,
            description = "Lie on your side with the bottom knee bent. Lift your hips and raise your top arm. Hold the position and repeat on the opposite side.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),
        Exercise(
            name = "Side Plank Extended Split",
            displayResId = R.drawable.side_plank_extended_split,
            description = "Lie on your side, place your top foot in front of your lower knee, and lift into a side plank. Raise your top leg and arm, and try to reach your foot with your hand. Hold and switch sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Plank Extended Split on Elbow",
            displayResId = R.drawable.side_plank_extended_split_on_elbow,
            description = "Lie on your side, step your top foot forward, and lift into a side plank on your elbow. Raise your top arm and leg, and try to hold your extended foot. Switch sides after holding.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Reach with Band or Towel",
            displayResId = R.drawable.side_reach_with_band_or_towel,
            description = "Hold a resistance band or towel overhead, pulling it apart. Lean to one side for a deep stretch, then switch sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Split Modification",
            displayResId = R.drawable.side_split_modification,
            description = "From a kneeling position, extend one leg out to the side and lean forward, pressing gently into the extended leg to stretch the calf. Switch legs after holding.",
            duration = 30,
            muscleGroups = listOf("Calves")
        ),

        Exercise(
            name = "Side Squat",
            displayResId = R.drawable.side_squat,
            description = "Start in a low squat and extend one leg out to the side. Lower your pelvis and drop your chest toward the floor. Hold and repeat on the other leg.",
            duration = 15,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Side Squat Arms Extended",
            displayResId = R.drawable.side_squat_arms_extended,
            description = "In a low squat, lower your hips to the floor. Extend one leg, wrap your arm around the opposite knee and bind your hands behind you. Hold and repeat on the other side.",
            duration = 20,
            muscleGroups = listOf("Adductors")
        ),
        Exercise(
            name = "Side Squat Lotus Reach",
            displayResId = R.drawable.side_squat_lotus_hand_extended,
            description = "Begin in a low squat, extend one leg to the side with pointed toes. Lean forward and place your hands on the floor in front of you, flaring your fingers in a lotus gesture. Lower your pelvis and hold. Repeat on the opposite side.",
            duration = 15,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Side Squat Leg Extended",
            displayResId = R.drawable.side_squat_stretch_extended_leg,
            description = "Stand with legs slightly bent and extend one leg out to the side. Bring your hands into prayer position and lean forward, resting your elbow on the opposite knee. Hold and repeat on the other side.",
            duration = 10,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Tiptoe Side Squat Reach",
            displayResId = R.drawable.side_squat_tiptoe_extended_leg_to_side,
            description = "Stand with legs slightly bent and extend one leg to the side. Rise onto your opposite foot's toes, twist your torso, and reach one arm to the floor while raising the other overhead. Hold and repeat on the opposite side.",
            duration = 15,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Seated Side Stretch",
            displayResId = R.drawable.side_stretch_arm_extended_seated_,
            description = "Sit on an exercise ball with legs wide apart. Lean your torso to one side, touching the floor with one hand and extending the other arm upward. Gaze toward your raised hand and hold. Repeat on the opposite side.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Overhead Clasp Side Stretch",
            displayResId = R.drawable.side_stretch_arms_clasped_overhead,
            description = "Stand with feet together and clasp your hands above your head. Lean your torso to one side while keeping your heels grounded. Hold and repeat on the opposite side.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Stretch Both Arms on Ball",
            displayResId = R.drawable.side_stretch_both_arms_on_ball_or_chair,
            description = "Kneel upright and bend forward at the waist, resting your forearms on a stability ball. Pull your head and shoulders down to increase pressure on your sides. Hold.",
            duration = 20,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Bent Elbow Side Stretch",
            displayResId = R.drawable.side_stretch_elbows_bent_overhead,
            description = "Stand with feet shoulder-width apart. Raise your arms and grasp opposite elbows overhead. Lean your torso to one side, keeping your heels grounded. Hold and repeat.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),
        Exercise(
            name = "Side Stretch Lying",
            displayResId = R.drawable.side_stretch_lying,
            description = "Lie on your left side and place both palms flat on the floor by your chest. Push your shoulders and torso up from the floor, straightening your arms for support. Hold and then switch sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Stretch on Ball or Chair",
            displayResId = R.drawable.side_stretch_on_ball_or_chair_arm_extended,
            description = "Kneel upright with an exercise ball at your side. Lower yourself onto the ball so it supports your torso, straighten your legs, and rest your hands on the back of your head. Maintain the position before switching sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side-Lying Side Stretch (Easy Mod)",
            displayResId = R.drawable.side_stretch_side_lying_easy_modification,
            description = "Lie on your side, bend your top leg and place the foot in front of your bottom thigh. Push your torso up with your arms to rest on your forearm and foot. Hold before switching sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Stretch Sitting Up Extended",
            displayResId = R.drawable.side_stretch_sitting_up_extended,
            description = "Lie on your left side with palms by your chest. Bend your top leg and place it in front. Push your shoulders and torso up by straightening your arms. Hold before switching sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Stretch Star Pose",
            displayResId = R.drawable.side_stretch_star_pose,
            description = "Stand with legs wide and toes pointed outward. Bend your torso to one side, touching your toes with one hand while raising the other hand upward. Look up and hold before switching sides.",
            duration = 20,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Side Twist Curved Spine",
            displayResId = R.drawable.side_twist_curved_spine,
            description = "Sit on an exercise ball with legs spread wide. Place your hands behind your head and elbows out. Drop your head and shoulders to one side and gently press against your head. Hold and repeat to the other side.",
            duration = 30,
            muscleGroups = listOf("Neck")
        ),

        Exercise(
            name = "Side Twist with Clasped Hand Seated",
            displayResId = R.drawable.side_twist_with_clasped_hand_seated,
            description = "Sit on an exercise ball, clasp your fingers, and raise your hands overhead. Twist your torso upward to one side and hold before switching sides.",
            duration = 15,
            muscleGroups = listOf("Latissimus dorsi")
        ),
        Exercise(
            name = "Sideways Intense Stretch Pose 2",
            displayResId = R.drawable.sideways_intense_stretch_pose_2,
            description = "Stand with feet together, bend at the waist, and twist to the right. Drop your palms to the floor beside your right foot and hold. Repeat on the other side.",
            duration = 20,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Sideways Spinal Stretch Toe Touch",
            displayResId = R.drawable.sideways_spinal_stretch_toe_touch,
            description = "Sit on the floor in a half-split pose. Drop your torso toward your extended leg and reach for your ankle. Reach your other arm behind your back to hold your thigh and gaze upward. Hold and switch sides.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Simple Side Stretch",
            displayResId = R.drawable.simple_side_stretch,
            description = "Stand with arms at your sides and feet together. Lean your torso to one side without bending forward. Slide your fingers down your leg and hold. Repeat on the opposite side.",
            duration = 15,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Sit Ups with Band",
            displayResId = R.drawable.sit_ups_with_band,
            description = "Lie on your back with a resistance band around your ankles. Lift your knees above your hips and crunch upward, keeping tension on the band. Lower back down and repeat.",
            duration = 30,
            muscleGroups = listOf("Abdominals")
        ),

        Exercise(
            name = "Six Triangle Pose",
            displayResId = R.drawable.six_triangle_pose,
            description = "Sit with knees bent and lean back on one forearm. Cross one foot over the opposite knee. Place your hands behind your head and twist your torso while gazing upward. Hold and switch sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Son of Anjani Forward Fold",
            displayResId = R.drawable.son_of_anjani_both_hands_to_foot_front_leg_straight,
            description = "Start in downward dog. Step one foot forward, lower the back knee, and lift the foot. Reach both hands to the lifted ankle and lean into a deep backbend. Hold before switching sides.",
            duration = 10,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Son of Anjani Lunge",
            displayResId = R.drawable.son_of_anjani_lunge_both_hands_to_foot,
            description = "Begin in downward dog. Step one foot forward and lower your back knee. Reach back with both hands to grab the rear ankle while arching your chest into a backbend. Hold and alternate sides.",
            duration = 10,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Spinal Curve with Feet on Ball",
            displayResId = R.drawable.spinal_curve_with_feet_on_ball,
            description = "Sit on an exercise ball with legs apart. Bring your knees together and rest your hands on them. Drop your head and shoulders forward, curving your spine deeply. Hold.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Spinal Twist Deep Seated",
            displayResId = R.drawable.spinal_twist_deep_seated,
            description = "Sit cross-legged and twist your torso over one thigh. Lower your torso and forearms to the floor and gaze upward. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Spinal Twist Modification",
            displayResId = R.drawable.spinal_twist_modification,
            description = "Sit with legs extended. Cross one leg over the other, placing the foot outside the thigh. Hold the knee and gently twist your torso from side to side. Repeat with the other leg.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),
        Exercise(
            name = "Spinal Twist on Ball",
            displayResId = R.drawable.spinal_twist_on_ball,
            description = "Sit on a fitness ball with a straight back and legs apart. Twist your torso to the right, grab the outside of your knee with the opposite hand, and extend your other arm behind while gazing upward. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Spinal Twist Seated",
            displayResId = R.drawable.spinal_twist_seated,
            description = "Sit on a chair with knees slightly apart. Twist to one side, placing one hand on the seat and the other on the chair’s back. Gaze over your shoulder and deepen the twist. Switch sides.",
            duration = 15,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Spine and Shoulder Twist",
            displayResId = R.drawable.spine_and_shoulder_twist_advanced,
            description = "Lie on your stomach with arms out to your sides. Lift your head and bring one leg across your body to the opposite side, placing toes near your hand. Hold and switch sides.",
            duration = 20,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Supported Revolved Squat",
            displayResId = R.drawable.squat_revolved_supported_hand_to_foot,
            description = "Crouch low and grab one foot with the opposite hand. Plant your other hand behind for support and straighten the leg while twisting your torso. Hold and alternate sides.",
            duration = 15,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Squat with Arms Clasped",
            displayResId = R.drawable.squat_with_arms_clasped,
            description = "Stand with arms clasped and extended ahead. Drop into a squat with thighs parallel to the floor. Hold for ten seconds and repeat.",
            duration = 10,
            muscleGroups = listOf("Quadriceps")
        ),

        Exercise(
            name = "Standing Hip Abduction",
            displayResId = R.drawable.standing_hip_abduction_,
            description = "With a resistance band above your ankles, lift one leg out to the side while maintaining balance and band tension. Lower and repeat on the other side.",
            duration = 30,
            muscleGroups = listOf("Abductors")
        ),

        Exercise(
            name = "Supine Lumbar Rotation",
            displayResId = R.drawable.supine_lumbar_rotation,
            description = "Lie on your back with knees bent and arms extended. Lower both knees to one side while keeping shoulders grounded. Hold and repeat on the other side.",
            duration = 15,
            muscleGroups = listOf("Lower back")
        ),

        Exercise(
            name = "Supported Arm Twist",
            displayResId = R.drawable.supported_arm_twist,
            description = "Stand near a wall, reach one arm behind your back, and press your opposite palm to the wall at shoulder height. Gently twist your torso away from the wall. Hold and alternate.",
            duration = 30,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Tennis Elbow Stretch",
            displayResId = R.drawable.tennis_elbow_stretch,
            description = "Stand straight with arms extended. With one hand, pull the opposite fingers back toward you to stretch the forearm. Hold and repeat on the other hand.",
            duration = 15,
            muscleGroups = listOf("Wrists")
        ),

        Exercise(
            name = "Thigh Quad Anterior Stretch",
            displayResId = R.drawable.thigh_quad_anterior_stretch,
            description = "Stand with arms out to the sides. Step one foot forward into a lunge, twisting the torso toward the front leg. Hold and alternate directions and legs.",
            duration = 10,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Extended Knee-to-Chest Stretch",
            displayResId = R.drawable.thigh_stretch_knee_to_chest_extended,
            description = "Sit with legs extended. Bring one foot on top of the opposite thigh and pull the leg toward your chest with both arms. Hold and repeat on the opposite leg.",
            duration = 10,
            muscleGroups = listOf("Abductors")
        ),
        Exercise(
            name = "Extended Knee-to-Chest Stretch 2",
            displayResId = R.drawable.thigh_stretch_knee_to_chest_extended2,
            description = "Crouch on tiptoes with your weight on the balls of your feet. Extend one leg out to the side and place the same-side hand across your body for support. Hold, then switch sides.",
            duration = 15,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Thoracic Rotation",
            displayResId = R.drawable.thoracic_rotation,
            description = "From an all-fours position, place one hand behind your head and rotate your elbow up and down above shoulder level. Repeat twenty times per arm.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Thoracic Rotation Side Lying",
            displayResId = R.drawable.thoracic_rotation_side_lying,
            description = "Lie on your back, knees bent and dropped to one side. Cross your arms and rotate your upper body toward the knees, then return. Repeat thirty times and switch sides.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Thunderbolt Pose Tiptoe",
            displayResId = R.drawable.thunderbolt_pose_tiptoe,
            description = "Kneel with feet together, lift onto your toes, and sit on your heels. Lean back and place palms on the floor behind you, opening the chest and dropping the head. Hold.",
            duration = 20,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Twisted Lotus",
            displayResId = R.drawable.twisted_lotus,
            description = "Sit with one foot in the opposite hip crease and the other crossed over. With your hands on your knees, twist your shoulders to one side while gazing the other way. Hold and switch.",
            duration = 20,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Twisted Lotus Variation",
            displayResId = R.drawable.twisted_lotus_variation,
            description = "Sit in lotus pose. Drop one shoulder to the opposite knee and extend your opposite arm straight upward while gazing to the ceiling. Hold and alternate sides.",
            duration = 20,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Tiptoe Side Stretch (Uneven Legs)",
            displayResId = R.drawable.uneven_legs_tiptoe_intense_side_stretch_pose_,
            description = "Step one foot forward and prop the back foot on tiptoes. Fold and twist the torso, placing one hand on the ground and reaching the other upward. Hold and switch sides.",
            duration = 30,
            muscleGroups = listOf("Chest opener")
        ),

        Exercise(
            name = "Tiptoe Side Stretch (Uneven Legs) Variation",
            displayResId = R.drawable.uneven_legs_tiptow_intense_side_stretch_pose_variation,
            description = "Step one foot forward and raise the back foot onto tiptoes. Fold forward and place both hands on the floor, allowing the head and shoulders to drop.",
            duration = 20,
            muscleGroups = listOf("Hamstrings")
        ),

        Exercise(
            name = "Pointed Toe Hamstring Stretch",
            displayResId = R.drawable.unilateral_hamstring_stretch_toe_pointed,
            description = "Lie flat and raise one straight leg above your hips. Reach behind your thigh and gently pull your leg toward your torso. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Hamstrings")
        ),

        Exercise(
            name = "Pointed Toe Knee-to-Chest",
            displayResId = R.drawable.unilateral_knee_to_chest_toe_pointed,
            description = "While lying flat, bend one knee into your chest and extend your leg upward. Reach around your thigh and pull your leg gently toward your chest. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Hamstrings")
        ),
        Exercise(
            name = "Tiger Pose",
            displayResId = R.drawable.tiger_pose,
            description = "Start on all fours, raise one leg straight up behind you without bending the knee. Hold for twenty seconds, then switch legs.",
            duration = 20,
            muscleGroups = listOf("Glutes")
        ),

        Exercise(
            name = "Tiptoe Balance Wrist Stretch",
            displayResId = R.drawable.tiptoe_balance_intense_wrist_stretch,
            description = "Crouch on tiptoes with knees wide. Place palms on the floor in front of you, fingers facing backward. Hold for twenty seconds.",
            duration = 20,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Tiptoe Stretch",
            displayResId = R.drawable.tiptoe_stretch,
            description = "Crouch on tiptoes with hands on knees for support. Slowly extend knees wide apart and hold for thirty seconds.",
            duration = 30,
            muscleGroups = listOf("Adductors")
        ),

        Exercise(
            name = "Torso Twist",
            displayResId = R.drawable.torso_twist,
            description = "Stand with legs apart, arms extended. Twist torso to touch opposite foot with hand, alternate sides for 20 reps.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Traction Lateral",
            displayResId = R.drawable.traction_lateral,
            description = "Stand beside a door frame. Reach both arms to grab the frame and shift hips to the side. Hold for thirty seconds.",
            duration = 30,
            muscleGroups = listOf("Latissimus dorsi")
        ),

        Exercise(
            name = "Tricep Dips High",
            displayResId = R.drawable.tricep_dips_high,
            description = "Stand behind a sturdy chair, grip the back, and lower your body by bending your elbows to 90 degrees. Repeat 5+ times.",
            duration = 30,
            muscleGroups = listOf("Triceps")
        ),

        Exercise(
            name = "Tricep Dips Low",
            displayResId = R.drawable.tricep_dips_low,
            description = "Sit in front of a block, hands behind you. Lower your body by bending elbows, then return. Repeat 5+ times.",
            duration = 30,
            muscleGroups = listOf("Triceps and biceps")
        ),

        Exercise(
            name = "Tricep Self-Stretch",
            displayResId = R.drawable.tricep_selfstretch,
            description = "Stand tall, bend one elbow behind your head, and use the opposite hand to push it lower. Hold for thirty seconds.",
            duration = 30,
            muscleGroups = listOf("Triceps and biceps")
        ),

        Exercise(
            name = "Trunk Rotator",
            displayResId = R.drawable.trunk_rotator,
            description = "Stand upright, elbows bent at sides. Twist torso left and right for twenty reps each side.",
            duration = 30,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Upper Back Extension",
            displayResId = R.drawable.upperback_extension,
            description = "Lie on your stomach and lift your chest using only back and core muscles. Hold for ten seconds, repeat.",
            duration = 10,
            muscleGroups = listOf("Upper back")
        ),

        Exercise(
            name = "Clenched Fingers Back Extension",
            displayResId = R.drawable.upperback_extension_with_clenched_fingers_advanced,
            description = "Lie facedown with hands clasped behind your back. Lift chest and arms. Hold for twenty seconds.",
            duration = 20,
            muscleGroups = listOf("Upper back")
        ),

        Exercise(
            name = "Upper Back Reaching",
            displayResId = R.drawable.upperback_reaching,
            description = "Crouch near a vertical structure. Reach to grab it with one hand and pull your back away. Hold for twenty seconds.",
            duration = 20,
            muscleGroups = listOf("Upper back")
        ),

        Exercise(
            name = "Crouching Spine Stretch",
            displayResId = R.drawable.upperback_spine_stretch_crouching,
            description = "Crouch with hands behind your head, pull head downward and push spine upward. Hold for twenty seconds.",
            duration = 20,
            muscleGroups = listOf("Spine")
        ),

        Exercise(
            name = "Ball Upper Back Twist",
            displayResId = R.drawable.upperback_twist_arms_extended_on_ball,
            description = "Sit on a ball, twist torso to one side while keeping hands on the back of your head. Hold and switch.",
            duration = 15,
            muscleGroups = listOf("Upper back")
        ),
        Exercise(
            name = "Western Stretch (Cow Face Variation)",
            displayResId = R.drawable.western_intense_stretch_half_cow_face_variation,
            description = "Sit with legs extended, cross one foot over the opposite thigh, lean forward placing hands beside the extended foot. Drop head and shoulders. Hold and switch sides.",
            duration = 15,
            muscleGroups = listOf("Upper back", "Hamstring")
        ),

        Exercise(
            name = "One-Hand Revolved Western Stretch",
            displayResId = R.drawable.western_intense_stretch_onehand_revolved,
            description = "Sit with legs extended, twist and fold to the right, placing left elbow on right thigh. Extend right arm overhead and gaze up. Hold and switch sides.",
            duration = 30,
            muscleGroups = listOf("Obliques")
        ),

        Exercise(
            name = "Western Stretch Palms to Floor",
            displayResId = R.drawable.western_intense_stretch_palms_to_floor,
            description = "Sit with legs extended, fold forward placing forehead on legs. Rest palms flat on the floor in front. Hold.",
            duration = 20,
            muscleGroups = listOf("Upper back", "Hamstring")
        ),

        Exercise(
            name = "Western Stretch Upward Half Dog",
            displayResId = R.drawable.western_intense_stretch_upward_half_dog,
            description = "Sit with knees bent, grab feet, then extend legs upward while balancing on sit bones. Rest forearms on shins and hold.",
            duration = 15,
            muscleGroups = listOf("Upper back")
        ),

        Exercise(
            name = "Wrist Bend",
            displayResId = R.drawable.wrist_bend,
            description = "Hold hands in front of chest with palms facing each other. Bend wrists so fingers point down. Hold and release.",
            duration = 15,
            muscleGroups = listOf("Wrists")
        ),

        Exercise(
            name = "Wrist Extensors Assisted",
            displayResId = R.drawable.wrist_extensor_assisted,
            description = "Extend right arm forward, palm out and thumb down. Use left hand to gently pull palm in. Hold and repeat other side.",
            duration = 15,
            muscleGroups = listOf("Wrist")
        ),

        Exercise(
            name = "Wrist Flexion",
            displayResId = R.drawable.wrist_flexion,
            description = "Raise left hand to chest and bend wrist down. Use right hand to press gently for a deeper stretch. Hold and switch.",
            duration = 15,
            muscleGroups = listOf("Wrist")
        ),

        Exercise(
            name = "Wrist Flexion Side",
            displayResId = R.drawable.wrist_flexion_side,
            description = "Extend right arm, palm out and thumb down. Pull back on palm using left hand. Hold and repeat with the other arm.",
            duration = 15,
            muscleGroups = listOf("Wrist")
        ),

        Exercise(
            name = "Wrist Rotation",
            displayResId = R.drawable.wrist_rotation,
            description = "Clasp palms together in front of chest. Rotate wrists clockwise and counterclockwise. Continue for full duration.",
            duration = 30,
            muscleGroups = listOf("Wrist")
        ),

        Exercise(
            name = "Wrist Rotations Up and Down",
            displayResId = R.drawable.wrist_rotations_upanddown,
            description = "With fingers clasped and palms together, rotate fingers in toward chest and then out. Repeat motion continuously.",
            duration = 30,
            muscleGroups = listOf("Wrist")
        ),

        Exercise(
            name = "Wrist Extensor Stretch",
            displayResId = R.drawable.wrist_ulnar_deviation_and_extensor_stretc,
            description = "On all fours, touch wrists together with fingers pointed outward. Press gently into the floor and hold.",
            duration = 15,
            muscleGroups = listOf("Wrist")
        ),

        Exercise(
            name = "Ulnar Wrist Flexor Stretch",
            displayResId = R.drawable.wrist_ulnar_deviation_and_flexor_stretch,
            description = "Crouch on all fours, turn hands so fingers face each other. Arch the back and drop shoulders. Hold.",
            duration = 15,
            muscleGroups = listOf("Wrist")
        )









    )
}


