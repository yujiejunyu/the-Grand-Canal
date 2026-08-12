# The-Grand-Canal · 大运河文化数字展馆

> 以「中国大运河」为主题的多模块静态文化展示网站，团队协作开发。
> 通过图文并茂、交互体验、历史长卷与小游戏等形式，展现大运河的历史脉络、风土人情与文化创意。

## 📖 项目简介

本项目是面向大运河文化的**前端静态站点**（纯 HTML + CSS + JavaScript，无需构建工具），由多人在 `main` 分支保护下协作开发完成。站点分为首页、历史、文化、文化创意、互动游戏五大板块，公共资源统一收纳在 `src/public` 下，便于团队复用与维护。

## 🧩 功能模块

| 板块 | 路径 | 说明 |
| ---- | ---- | ---- |
| 🏠 首页 | `src/Cannal-index/index.html` | 站点入口，含图片轮播 / 拖拽交互导航 |
| 📜 历史 | `src/Cannal-history/Canal_history.html` | 大运河历史长卷与事件脉络 |
| 🏮 文化 | `src/Cannal-culture/culture.html` | 运河文化、民俗、非遗等内容展示 |
| 🎨 文化创意 | `src/Cannal-creativity/cultural.html` | 文创设计与创意呈现 |
| 🎮 互动游戏 | `src/Cannal-game/html/长地图版-游戏初稿.html` | 运河主题互动小游戏（含骰子玩法初稿） |
| 📦 公共资源 | `src/public/` | 公共 CSS / JS / 图片 / 音效，供各模块复用 |

## 🗂 目录结构

```
The-Grand-Canal/
├── Document/                 # 项目文档与素材（华灿奖大运河.pdf、美食资料、音效收集等）
├── src/
│   ├── Cannal-index/         # 首页模块
│   ├── Cannal-history/       # 历史模块
│   ├── Cannal-culture/       # 文化模块
│   ├── Cannal-creativity/    # 文化创意模块
│   ├── Cannal-game/          # 互动游戏模块
│   └── public/               # 公共资源（css / js / image / media）
└── README.md
```

## 🚀 快速开始

1. 克隆仓库：

   ```bash
   git clone git@github.com:yujiejunyu/The-Grand-Canal.git
   ```

2. 直接打开入口页面：

   ```bash
   # 浏览器打开
   src/Cannal-index/index.html
   ```

   或在本地起一个静态服务（推荐，避免资源路径问题）：

   ```bash
   # 任选其一
   python -m http.server 8080
   # 或
   npx serve .
   ```

   然后访问 `http://localhost:8080/src/Cannal-index/index.html`。

## 👥 团队成员

- 余俊（23 软件工程一班）
- 李佳慧（23 计算机科学与技术 2 班）
- 郑书旷
- 马明理
- 李佳慧等

## 📌 协作规范

### ⚠️ 注意事项

1. 仓库已设置**分支保护规则**：`main` 分支被锁定，**无法直接合并分支到 main**，务必自行创建分支！
2. 如果是**第一次**使用仓库，可以修改 `Document/test.txt` 添加自己的名字等信息，并提交推送到远程仓库，确认仓库使用顺利。
3. 合并到 `main` 主分支之前，请先 `git pull` 更新同步主分支记录到自己的分支，以防因本地记录更新不及时导致其他贡献者的提交丢失！

### 📦 仓库规范

1. 新增分支：以自己名字命名，或名字拼音、首字母均可；
2. 提交命名规范：`add新增 + 名字 + commit{次数}`；
3. 发起拉取请求（Pull Request）。

### 💻 项目规范

1. 新建代码文件命名：`名字首字母大写 + 文件名称`；
2. 新建变量命名：`名字首字母大写 + 变量名称`（变量尽量命名规范，避免 `a`、`b`、`c` 等影响代码理解）；
3. 各页面都需要的 JS 放在 `public/js` 中，仅单独板块使用的 JS 放在对应板块目录下。

## 🔧 常用 Git 指令

| 操作 | 命令 |
| ---- | ---- |
| 克隆地址 | `git clone git@github.com:yujiejunyu/The-Grand-Canal.git` |
| 创建分支 | `git checkout -b [你的分支名称]` |
| 切换分支 | `git checkout [你的分支名称]` |
| 添加文件追踪 | `git add .` |
| 添加提交备注 | `git commit -m "你的提交备注，要求一眼就能看出做了什么"` |
| 推送代码到远程分支 | `git push` |
| 代码 merge 合并 | `git merge [目标分支名称]`（**禁止使用变基合并方式**） |
| 同步远程分支代码到本地 | `git pull` |
