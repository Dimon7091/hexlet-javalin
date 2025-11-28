@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Моё Приложение</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        header { background: #f0f0f0; padding: 10px; border-bottom: 1px solid #ccc; }
        nav a { margin-right: 15px; text-decoration: none; color: #333; }
        main { margin: 20px 0; }
        footer { text-align: center; margin-top: 20px; font-size: 0.9em; color: #666; }
    </style>
</head>
<body>
<header>
    <nav>
        <a href="/">Главная</a> |
        <a href="/courses/build">Создать курс</a> |
        <a href="/courses">Курсы</a> | |
        <a href="/users/build">Создать пользователя</a> |
        <a href="/users">Все пользователи</a>
    </nav>
</header>

<main>
    <div class="content">
        ${content}
    </div>
</main>
<footer class="footer">
    <p>&copy; 2025 Приложение на JTE. Автор: Мой профиль на GitLab - <a href="https://gitlab.com/username" target="_blank">gitlab.com/username</a></p>
</footer>
</body>
</html>
