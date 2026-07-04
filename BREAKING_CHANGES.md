This file documents all the breaking changes between releases. "Breaking change" here refers to a change that is not backwards compatible in day-to-day gameplay, e.g. an ID change.

It is always recommended to manually check git diffs if you are deeply dependent on this mod.

<details>
  <summary>v1.0.0 Development</summary>

### v1.0.0-beta.1..v1.0.0-beta.2
None

### v1.0.0-beta.2..v1.0.0-beta.3
None

### v1.0.0-beta.3..v1.0.0-beta.4
None

### v1.0.0-beta.4..v1.0.0-beta.5
- Recipes have shifted due to the addition of Colored Vanilla Glass
  - May or may not affect gameplay. Check specifics .
- `assets/textures/minecraft` and `assets/textures/betterglass` have been moved to a resource pack
  - Should have no major effect on gameplay, still notable
- Removed glasscutter font's individual png assets

### v1.0.0-beta.5..v1.0.0-beta.6
- Renamed various tags
  - `clear_glass` -> `clear_glass_block`
  - `scratched_glass` -> `scratched_glass_block`
  - `colored_glass` -> `colored_glass_block`
  - `stained_glass` -> `stained_glass_block`
  - `colored_clear_glass` -> `colored_clear_glass_block`
  - `stained_clear_glass` -> `stained_clear_glass_block`
  - `colored_scratched_glass` -> `colored_scratched_glass_block`
  - `stained_scratched_glass` -> `stained_scratched_glass_block`
  - `stained_vanilla_glass` -> `stained_vanilla_glass_all`
  - `colored_vanilla_glass` -> `colored_vanilla_glass_block`
- Split tags
  - `clear_glass_all`
  - `clear_glass_pane`
  - `scratched_glass_all`
  - `scratched_glass_pane`
  - `colored_glass_all`
  - `colored_glass_pane`
  - `stained_glass_all`
  - `stained_glass_pane`
  - `colored_clear_glass_all`
  - `colored_clear_glass_pane`
  - `stained_clear_glass_all`
  - `stained_clear_glass_pane`
  - `colored_scratched_glass_all`
  - `colored_scratched_glass_pane`
  - `stained_scratched_glass_all`
  - `stained_scratched_glass_pane`
  - `colored_vanilla_glass_all`
  - `colored_vanilla_glass_pane`
- All the tag changes caused major changes to recipes, translation keys, and of course, tag definition and contents
- Changed dependencies
  - `fabricloader`: `>=0.19.2` -> `>=0.18.5`
  - `minecraft`: `~26.1.2` -> `~26.1`
  - `fabric-api`: `*` -> `>=0.144.0`
- Model Generation now uses `createGlassBlocks()` instead of `createTrivialCube()` for Glass blocks

### v1.0.0-beta.6..v1.0.0-beta.7
- Refactored Recipe Generation
  - This renamed certain criteria.
    - `has_*_stained_vanilla_glass` -> `has_*_stained_glass`
    - `has_stained_vanilla_glass` -> `has_stained_glass`
    - `has_*_stained_vanilla_glass_pane` -> `has_*_stained_glass_pane`
    - `has_stained_vanilla_glass_pane` -> `has_stained_glass_pane`
  - Additionally, `/data/betterglass/advancement/recipes/decorations/*_colored_vanilla_glass_pane_from_*_stained_glass_pane_via_crafting_table` had `has_stained_glass` as a criteria. This has been fixed in favor of `has_stained_glass_pane`.
- Language Files are now part of datagen

### v1.0.0-beta.7..v1.0.0-pre.1
None

### v1.0.0-pre.1..v1.0.0-pre.2
- Removed some unnecessary items, not really breaking

### v1.0.0-pre.2..v1.0.0-rc.1
None
</details>

### v1.0.0..v1.0.1
None

<details>
  <summary>v1.1.0 Development</summary>

### v1.0.1..v1.1.0-beta.1
None

### v1.1.0-beta.1..v1.1.0-beta.2
- Removed Chiseled Glass from tags
  - `c/block/glass_blocks`
  - `c/block/glass_blocks/cheap`
  - `c/block/glass_blocks/tinted`
  - `c/item/glass_blocks`
  - `c/item/glass_blocks/cheap`
  - `c/item/glass_blocks/tinted`
  - `minecraft/block/impermeable`
- Chiseled Tinted Glass no longer needs Silk Touch to drop

### v1.1.0-beta.2..v1.1.0-pre.1
- Moved `transmasc_pattern_from_transgender_pattern` to `transmasc_pattern_from_transfem_pattern`
- Removed Patterned Glass from `c/block/glass_blocks/cheap` and `c/item/glass_blocks/cheap` tags

### v1.1.0-pre.1..v1.1.0-rc.1
- Moved certain "custom" tops to palettes
  - `checkerboard`: `special_checkerboard`
  - `null`: `special_null`
  - `bigender`: `special_bigender`
  - `bisexual`: `special_bisexual`
  - `genderfluid`: `special_genderfluid`
  - `genderqueer`: `special_genderqueer`
  - `lesbian`: `special_lesbian`
  - `mlm`: `special_mlm`
  - `pansexual`: `special_pansexual`
  - `polyamory`: `special_polyamory`
  - `polyamory_new`: `special_polyamory_new`
</details>

### v1.0.1..v1.1.0
None

### v1.1.0..v1.1.1
None