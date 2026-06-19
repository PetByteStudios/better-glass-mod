[![Build](https://github.com/PetByteStudios/better-glass-mod/actions/workflows/build.yml/badge.svg?branch=mc26.2.x/v1.1.x)](https://github.com/PetByteStudios/better-glass-mod/actions/workflows/build.yml?query=branch%3Amc26.2.x%2Fv1.1.x)
[![Check](https://github.com/PetByteStudios/better-glass-mod/actions/workflows/check.yml/badge.svg?branch=mc26.2.x/v1.1.x)](https://github.com/PetByteStudios/better-glass-mod/actions/workflows/check.yml?query=branch%3Amc26.2.x%2Fv1.1.x)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/EvcABx9Z?color=1BD96A&label=Downloads&logo=modrinth)](https://modrinth.com/mod/petbyte-better-glass)
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1564161?color=F16436&label=Downloads&logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/petbyte-better-glass)
[![Modrinth Followers](https://img.shields.io/modrinth/followers/EvcABx9Z?color=1BD96A&label=Followers&logo=modrinth&style=flat)](https://modrinth.com/mod/petbyte-better-glass)

<span title="Latest tag on this repository">[![Latest Tag](https://img.shields.io/github/v/tag/PetByteStudios/better-glass-mod?color=00AF5C&label=latest%20tag)](https://github.com/PetByteStudios/better-glass-mod/tags)</span>
<span title="Latest tag for this MC version">[![MC latest Tag](https://img.shields.io/github/v/tag/PetByteStudios/better-glass-mod?color=00AF5C&label=latest%20tag%2026.2.x&filter=*mc26.2*)](https://github.com/PetByteStudios/better-glass-mod/tags)</span>
<span title="Latest tag on this specific branch">[![Branch latest Tag](https://img.shields.io/github/v/tag/PetByteStudios/better-glass-mod?label=latest%20tag%20on%20branch&color=00AF5C&filter=v1.1.*mc26.2*)](https://github.com/PetByteStudios/better-glass-mod/tags)</span>

<span title="Latest available release on Modrinth">[![Modrinth Latest Version](https://img.shields.io/modrinth/v/EvcABx9Z?color=1BD96A&label=latest&logo=modrinth)](https://modrinth.com/mod/petbyte-better-glass)
</span>
<span title="Latest available release on CurseForge">[![CurseForge Latest Version](https://img.shields.io/curseforge/v/1564161?color=F16436&label=latest&logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/petbyte-better-glass)</span>

[![Modloader: Fabric](https://img.shields.io/badge/modloader-Fabric-DBD0B4?logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA0AAAAOCAMAAADDoWbgAAAAAXNSR0IArs4c6QAAABtQTFRFAAAAODQqgHptmpJ+rqaUvLKcxryl29C06OjofgVYZwAAAAl0Uk5TAP//////////NwKb1AAAAEdJREFUCJlVzkESgDAIQ1G+BXL/GzuCrcjuTQaIWQ82Bk2Sg4g4JPURqQgNKTO42ImiIrwSRW2xvJP34MM431geowmLX6+NG40KAXPnwSHdAAAAAElFTkSuQmCC)](https://fabricmc.net)
<span title="All versions supported by this mod">[![Supports](https://img.shields.io/badge/dynamic/json?color=4BAB62&label=supports&query=game_versions&cacheSeconds=3600&url=https://api.modrinth.com/v2/project/EvcABx9Z)](https://modrinth.com/mod/petbyte-better-glass)</span>
[![Environment](https://img.shields.io/badge/environment-Client%20%2B%20Server-yellow)](#)

[![License](https://img.shields.io/badge/license-MIT%20%28with%20exceptions%29-blue)](LICENSE)
<details>
<summary>Repository Stats (often broken lol)</summary>

[![Last Commit](https://img.shields.io/github/last-commit/PetByteStudios/better-glass-mod)](#)
[![Stars](https://img.shields.io/github/stars/PetByteStudios/better-glass-mod?color=blue&style=flat)](#)
[![Issues](https://img.shields.io/github/issues/PetByteStudios/better-glass-mod?color=red)](https://github.com/PetByteStudios/better-glass-mod/issues)
[![Code Size](https://img.shields.io/github/languages/code-size/PetByteStudios/better-glass-mod)](#)
[![Activity](https://img.shields.io/github/commit-activity/m/PetByteStudios/better-glass-mod)](#)
[![Contributors](https://img.shields.io/github/contributors/PetByteStudios/better-glass-mod)](https://github.com/PetByteStudios/better-glass-mod/graphs/contributors)
</details>

[![Made with](https://img.shields.io/badge/made%20with-%E2%9D%A4%EF%B8%8F-FFB301)](https://petbyte.dev/mods#better-glass)
[![Badges](https://img.shields.io/badge/did%20i%20add-enough%20badges%20yet%3F-white)](#)

# Better Glass
Better Glass is a Fabric mod that adds 361 new Glass Blocks, and way more to come!

It also adds recipes to re-dye and un-dye Vanilla Glass, recipes to remove tint from glass, and Continuity integration!

# Current Features
- 361 new Glass blocks (Clear, Scratched; both in Stained and Colored variants, those yet again in tinted variants, and those all yet again in panes (it's so many))
- Continuity Connected Glass integration
- Recipes for un-dyeing and re-dyeing any Glass
- Recipes for un-tinting Glass

# Dev Notes & Roadmap
This is not the final release. Further updates are planned, below is a list of temporary things and future plans.

## Glasscutter
Currently, the Glasscutter is just a prettier Stonecutter. There is no functional difference.

In a future update, likely v1.3.0, the Glasscutter will gain independent functionality. When this happens, all Crafting Table recipes related to `betterglass` will be deleted (unless I decide against this).

The Glasscutter will be a Work Block all about Glass. It will be used to convert between Blocks and Panes; Clear, Scratched, Vanilla, and other types; Dye and Stain Glass; Tint and Un-Tint Glass; and maybe as a Villager Workstation, too.

## Connecting and Non-Connecting Glass
As of v1.0.0, all Glass Blocks (`minecraft:` or `betterglass:`) automatically connect.

In a future version, all glass blocks will have separate Connecting and Non-Connecting variants. This will likely be done using a blockstate that can be modified with a new tool.

## More Glass Types
Of course. A mod all about Glass won't just stop at 300-something Glass Blocks.

More to come.